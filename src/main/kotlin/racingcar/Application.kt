package racingcar

import camp.nextstep.edu.missionutils.Randoms

// Car 데이터 클래스 정의
data class Car(val name: String, var count: Int)

val carNames = mutableListOf<Car>() // Car 객체를 저장하는 리스트

fun checkInputIsValid(input: String?) {
    input?.let { nonNullInput ->
        val trimmedInput = nonNullInput.trim()
        checkInputIsNull(trimmedInput)
    }
}

fun checkInputIsNull(trimmedInput: String){
    if (trimmedInput.isNotEmpty()) {
        val carNameList = trimmedInput.split(",").map { it.trim() }.filter { it.isNotBlank() }
        carNameIsEmpty(carNameList)

        carNameIsDoubled(carNameList)

        carNames.addAll(carNameList.map { Car(it, 0) }) // Car 객체로 저장
    } else {
        throw IllegalArgumentException("적어도 1대 이상의 자동차 이름을 입력해주세요.")
    }
}

fun carNameIsEmpty(carNameList: List<String>){
    if (carNameList.isEmpty()) {
        throw IllegalArgumentException("적어도 1대 이상의 자동차 이름을 입력해주세요.")
    }
}

fun carNameIsDoubled(carNameList: List<String>){
    if (carNameList.size != carNameList.distinct().size) {
        throw IllegalArgumentException("중복된 자동차 이름이 입력되었습니다.")
    }
}

fun moveOrStop(index: Int){
    val randomNumber = Randoms.pickNumberInRange(0, 9)
    if(randomNumber >= 4){
        carNames[index].count +=1
    }
    print("${carNames[index].name} : ${"-".repeat(carNames[index].count)}\n")
}

//자동차 갯수만큼 전진(move) or 멈춤(stop) 진행
fun playByCarSize(){
    for (j in 0 until carNames.size) {
        moveOrStop(j)
    }
    print("\n")
}

fun findNameOfWinnerWithMaxCount(): List<String> {
    val maxCount = carNames.maxByOrNull { it.count }?.count
    val winners = carNames.filter { it.count == maxCount }
    return winners.map { it.name }
}

fun main() {
    print("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)\n")
    val input = readLine()

    checkInputIsValid(input);

    val invalidCarNames = carNames.filter { it.name.length > 5 }
    if (invalidCarNames.isNotEmpty()){
        throw IllegalArgumentException("자동차의 입력값의 길이는 5 이하로 입력해주세요.")
    }

    print("시도할 횟수는 몇 회인가요?\n")
    val playTime = readLine()

    val playTimeAsInt: Int

    try {
        playTimeAsInt = playTime!!.toInt()
    } catch (e: NumberFormatException) {
        throw IllegalArgumentException("유효한 정수를 입력해주세요.")
    }

    print("\n실행 결과\n")

    // 경주 게임 실행
    for (i in 1..playTimeAsInt) {
        playByCarSize()
    }

    //최종 우승자 출력
    val winnerNames = findNameOfWinnerWithMaxCount()
    print("최종 우승자 : ${winnerNames.joinToString(", ")}")

}
