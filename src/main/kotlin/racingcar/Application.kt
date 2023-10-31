package racingcar

import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.Randoms

class InputHandler {
    fun start() {
        val carNames = getCarNames()
        val roundCount = getRoundCount()

        val carResults = simulateRace(carNames, roundCount)

        println("경주할 자동차 이름: ${carNames.joinToString(", ")}")
        println("실행 횟수: $roundCount")
        println("실행 결과:")
        carResults.forEach { (carName, results) ->
            println("$carName: ${results.joinToString(", ")}")
        }
        println("실행 종료!")
    }

    private fun getCarNames(): List<String> {
        println("경주할 자동차 이름을 5자 이하로 입력해주세요:")
        val input = Console.readLine()
        return input.split(",").map { it.trim() }
    }

    private fun getRoundCount(): Int {
        println("시도할 횟수를 입력하세요:")
        val input = Console.readLine()
        return input.toIntOrNull() ?: 0
    }

    private fun simulateRace(carNames: List<String>, roundCount: Int): Map<String, List<Int>> {
        val carResults = mutableMapOf<String, List<Int>>()

        carNames.forEach { carName ->
            val results = (1..roundCount).map { Randoms.pickNumberInRange(0, 9) }
            carResults[carName] = results
        }

        return carResults
    }
}

fun main() {
    val inputHandler = InputHandler()
    inputHandler.start()
}