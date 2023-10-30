package racingcar
import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.Randoms

fun main() {
    val carNames = inputCarNames()
    val trynum = inputTryCount()
    val goCount = raceCar(carNames, trynum)
    printRaceResults(carNames, goCount)
    printWinners(carNames, goCount)
}

fun inputCarNames(): List<String> {
    println("경주할 자동차 이름을 입력하세요. (이름은 쉼표(,) 기준으로 구분)")
    val carNamesInput = Console.readLine()
    val carNames = carNamesInput.split(",").map { it.trim() }

    if (carNames.any { it.length > 5 }) {
        throw IllegalArgumentException("자동차 이름은 5글자 이하여야 합니다.")
    }

    return carNames
}

fun inputTryCount(): Int {
    println("시도할 횟수는 몇 회 인가요?")
    return Console.readLine().toInt()
}

fun raceCar(carNames: List<String>, trynum: Int): Array<Int> {
    val goCount = Array(carNames.size) { 0 }
    for (i in 1..trynum) {
        for (j in carNames.indices) {
            if (Randoms.pickNumberInRange(0, 9) >= 4) {
                goCount[j]++
            }
        }
    }
    return goCount
}

fun printRaceResults(carNames: List<String>, goCount: Array<Int>) {
    println("\n실행 결과")
    for (i in carNames.indices) {
        val distance = "-".repeat(goCount[i])
        println("${carNames[i]} : $distance")
    }
}


fun printWinners(carNames: List<String>, goCount: Array<Int>) {
    val maxCount = goCount.max()
    val winners = carNames.filterIndexed { index, _ -> goCount[index] == maxCount }
    println("최종 우승자 : ${winners.joinToString(",")}")
}

