package racingcar

import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.Randoms
import java.lang.IllegalArgumentException

fun main() {
    val carNames = inputCarNames()
    val numberOfAttempts = inputNumberOfAttempts()
    val carNameAndScore = runCarRace(carNames, numberOfAttempts)
    showWinners(carNameAndScore)
}

fun inputCarNames(): List<String> {
    println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)")
    val carNames = Console.readLine().split(",")
    val validNames = carNames.filter { it.length <=5 }

    if (validNames.size != carNames.size) {
        throw IllegalArgumentException("5자 이하로 입력해주세요")
    }

    return validNames
}

fun inputNumberOfAttempts(): Int {
    println("시도할 횟수는 몇 회인가요?")
    return Console.readLine().toInt()
}

fun runCarRace(carNames: List<String>, numberOfAttempts: Int): Map<String, Int> {
    val carNameAndScore = initializeScores(carNames)
    println("실행 결과")
    for (i in 1..numberOfAttempts) {
        updateScores(carNames, carNameAndScore)
        showResults(carNameAndScore)
        println()
    }
    return carNameAndScore
}

fun initializeScores(carNames: List<String>): MutableMap<String, Int> {
    val carNameAndScore = mutableMapOf<String, Int>()
    for (carName in carNames) {
        carNameAndScore[carName] = 0
    }
    return carNameAndScore
}

fun updateScores(carNames: List<String>, carNameAndScore: MutableMap<String, Int>) {
    for (carName in carNames) {
            if (carNameAndScore.containsKey(carName) && Randoms.pickNumberInRange(0, 9) >= 4) {
                carNameAndScore[carName] = carNameAndScore[carName]!! + 1
            }
    }
}

fun showResults(carNameAndScore: Map<String, Int>) {
    for ((carName, score) in carNameAndScore) {
        val scoreResult = "-".repeat(score)
        println("$carName : $scoreResult")
    }
}

fun showWinners(carNameAndScore: Map<String, Int>) {
    val winners = carNameAndScore.filter { it.value == carNameAndScore.values.maxOrNull() }.keys
    println("최종 우승자 : ${winners.joinToString(", ")}")
}