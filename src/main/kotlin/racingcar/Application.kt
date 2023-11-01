package racingcar
import camp.nextstep.edu.missionutils.Randoms
import camp.nextstep.edu.missionutils.Console


fun main() {
    // TODO: 프로그램 구현
    val carsName = inputCarsName()
    val carsList: List<String> = addCarsList(carsName)
    checkUserInput(carsList)

    val repeatNum: Int = inputNum()
    val cntList: MutableMap<String, Int> = mutableMapOf()

    repeat(repeatNum) {
        for(carName in carsList){
            val randomNum = setRandomNum()
            compareNum(randomNum, carName, cntList)
            printDash(carName, cntList[carName] ?: 0)

        }
    }
    val winner = determineWinner(cntList)
    println("최종 우승자 : ${winner.joinToString(", ")}")
}
fun inputCarsName() : String{
    println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)")
    return readLine().toString()
}

fun addCarsList(carsName: String) : List<String> {
    val splitResult = carsName.split(",").map { it.trim() }
    return splitResult
}

fun compareNum(randomNum: Int, carName: String, cntList: MutableMap<String, Int>) {
    if(randomNum >= 4){
        cntList[carName] = cntList.getOrDefault(carName, 0) + 1
    }
}
fun inputNum() : Int {
    println("시도할 횟수는 몇 회인가요?")
    val repeitNum = readLine()?.toInt()?: 0
    return repeitNum
}
fun setRandomNum() :Int {
    val randomNum = Randoms.pickNumberInRange(0, 9)
    return randomNum
}
fun checkUserInput(names: List<String>) {
    names.forEach { name ->
        if (name.length > 5) {
            throw IllegalArgumentException("자동차 이름은 5자 이하로 입력해야 합니다.")
        }
    }
}
fun printDash(res: String, count: Int) {
    val dashLine = "-".repeat(count)
    println("${res} : ${dashLine}")
}

fun determineWinner(cntList: MutableMap<String, Int>): List<String> {
    val maxCount = cntList.values.maxOrNull()
    val winners = cntList.filterValues { it == maxCount }.keys.toList()
    return winners
}