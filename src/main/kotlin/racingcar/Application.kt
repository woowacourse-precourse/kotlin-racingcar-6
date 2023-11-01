package racingcar

import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.Randoms

class InputHandler {
    fun start() {
        val carNames = getCarNames()
        val roundCount = getRoundCount()

        val carResults = mutableMapOf<String, MutableList<String>>()
        val randomGenerator = RandomGenerator()

        repeat(roundCount) {
            carNames.forEach { carName ->
                val randomValue = randomGenerator.generate()
                val position = if (randomValue >= 4) "-" else ""
                carResults.computeIfAbsent(carName) { mutableListOf() }.add(position)
                println("$carName: ${carResults[carName]!!.joinToString("")}")
            }
            println()
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

    private class RandomGenerator {
        fun generate(): Int {
            return Randoms.pickNumberInRange(0, 9)
        }
    }
}

fun main() {
    val inputHandler = InputHandler()
    inputHandler.start()
}