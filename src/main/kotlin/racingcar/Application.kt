package racingcar


import camp.nextstep.edu.missionutils.Randoms

fun main() {

    val carPositions = gameRun()
    winner(carPositions)
    /*
    repeat(5) {
        print("이동수" + carPosition(randomValue())) //이동수- 이동수- 이동수-
    }
     */

}

fun inputCar(): List<String> {                              // 자동차 이름들 입력
    println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)")
    val input = readLine()!!    // 그냥 엔터를 쳤을때는?
    val carNames = input.split(",").map{ it.trim() } // 각 문자열 공백 제거

    carNames.forEach{
        if(it.length > 5) throw IllegalArgumentException()
    }

    return carNames
}
fun numberOfAttempts() : Int {                              // 시도 횟수
    println("시도할 횟수는 몇 회인가요?")
    val input = readLine()?:(throw IllegalArgumentException())
    return input.toInt()
}

fun randomValue() : Int{                                    // 전진 랜덤수 0 ~ 9
    var randNum = Randoms.pickNumberInRange(0,9)
    return randNum
}

fun carAndMove(carNames : List<String>, tryNum : Int) : Map<String, Int> { // 전진 출력
    val carPositions = mutableMapOf<String, Int>()
    // 초기 위치 설정
    carNames.forEach { car ->
        carPositions[car] = 0
    }

    repeat(tryNum) {
        carNames.forEach { car ->
            if (randomValue() >= 4) {
                carPositions[car] = carPositions[car]!! + 1
            }
            println("$car : ${"-".repeat(carPositions[car]!!)}")
        }
        println()
    }
    return carPositions
}

fun winner(carPositions: Map<String, Int>) {
    val maxPosition = carPositions.values.maxOrNull()
    val winners = carPositions.filter { it.value == maxPosition }.keys.joinToString(", ")

    println("최종 우승자 : $winners")
}

fun gameRun(): Map<String, Int> {
    return carAndMove(inputCar(), numberOfAttempts())
}





