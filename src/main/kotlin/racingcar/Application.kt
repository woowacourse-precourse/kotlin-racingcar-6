package racingcar

import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.Randoms

fun main() {
    val carNames = inputCarNames()
    val trynum = inputTryCount()
    val goCounts = simulateRace(carNames, trynum)
    printRaceResults(carNames, goCounts)
    val winners = determineWinners(carNames, goCounts)
    printWinners(winners)
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

fun simulateRace(carNames: List<String>, trynum: Int): List<Int> {
    val goCounts = MutableList(carNames.size) { 0 }

    repeat(trynum) {
        val moveCounts = move(carNames)
        for (i in carNames.indices) {
            goCounts[i] += moveCounts[i]
        }
    }

    return goCounts
}

fun move(carNames: List<String>): List<Int> {
    return carNames.map {
        if (Randoms.pickNumberInRange(0, 9) >= 4) 1 else 0
    }
}

fun printRaceResults(carNames: List<String>, goCounts: List<Int>) {
    println("\n실행 결과")
    for (i in carNames.indices) {
        val distance = "-".repeat(goCounts[i])
        println("${carNames[i]} : $distance")
    }
}

fun determineWinners(carNames: List<String>, goCounts: List<Int>): List<String> {
    val maxCount = goCounts.maxOrNull()
    return carNames.filterIndexed { index, _ -> goCounts[index] == maxCount }
}

fun printWinners(winners: List<String>) {
    println("최종 우승자 : ${winners.joinToString(", ")}")
}
