package racingcar

import camp.nextstep.edu.missionutils.Console
import kotlin.system.exitProcess

fun main() {
    val carNames = getCarNames()
    val tryCount = getTryCount()

    println()
    println("실행 결과")

    val raceResults = initializeRaceResults(carNames)
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