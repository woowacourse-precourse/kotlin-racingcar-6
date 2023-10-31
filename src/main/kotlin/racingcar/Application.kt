package racingcar

import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.Randoms
import kotlin.system.exitProcess

fun main() {
    val carNames = getCarNames()
    val tryCount = getTryCount()

    println()
    println("실행 결과")

    val raceResults = initializeRaceResults(carNames)

    conductRace(carNames, tryCount, raceResults)

    val winners = determineWinners(raceResults)

    printWinners(winners)
}

fun getCarNames(): List<String> {
    println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)")
    val carNames = Console.readLine()
    checkCarNames(carNames)
    return carNames.split(",")
}

fun checkCarNames(carNames: String) {
    val names = carNames.split(",")
    if (names.any { it.isEmpty() || it.length > 5 }) {
        exitProcess(0)
    }
}

fun getTryCount(): Int {
    println("시도할 횟수는 몇 회인가요?")
    val tryCountInput = Console.readLine()

    return tryCountInput.toIntOrNull() ?: exitProcess(0)
}

fun initializeRaceResults(carNames: List<String>): MutableMap<String, Int> {
    val raceResults = mutableMapOf<String, Int>()
    carNames.forEach { carName ->
        raceResults[carName] = 0
    }
    return raceResults
}

fun conductRace(carNames: List<String>, tryCount: Int, raceResults: MutableMap<String, Int>) {
    for (i in 1..tryCount) {
        carNames.forEach { carName ->
            val randomValue = Randoms.pickNumberInRange(0, 9)
            val forward = randomValue >= 4

            val result = calculateResult(raceResults, carName, forward)
            raceResults[carName] = result.length

            println("$carName : $result")
        }
        println()
    }
}

fun calculateResult(raceResults: Map<String, Int>, carName: String, forward: Boolean): String {
    val dashes = "-".repeat(raceResults[carName] ?: 0)
    return if (forward) "$dashes-" else dashes
}

fun determineWinners(raceResults: Map<String, Int>): String {
    val maxDistance = raceResults.values.max()
    val winners = raceResults.filter { it.value == maxDistance }.keys.joinToString(", ")
    return "최종 우승자 : $winners"
}

fun printWinners(winners: String) {
    print(winners)
}