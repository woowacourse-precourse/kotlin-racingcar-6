package racingcar

import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.Randoms

class InputHandler {
    private val raceResults: MutableList<MutableList<String>> = mutableListOf()
    private val carNames: List<String>

    init {
        carNames = getCarNames()
    }

    fun start() {
        val roundCount = getRoundCount()
        val randomGenerator = RandomGenerator()

        println("실행 결과")
        repeat(roundCount) {
            val roundResults = mutableListOf<String>()
            carNames.forEach { carName ->
                val randomValue = randomGenerator.generate()
                val position = if (randomValue >= 4) "-" else ""
                roundResults.add(position)
                println("$carName: ${roundResults.joinToString("")}")
            }
            raceResults.add(roundResults)
            println()
        }

        println("최종 우승자: ${findWinners()}")
    }

    private fun getCarNames(): List<String> {
        println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)")
        val input = Console.readLine()
        val carNames = input.split(",").map { it.trim() }

        if (carNames.any { it.length > 5 }) {
            throw IllegalArgumentException("자동차 이름을 5자 이하로 입력해주세요.")
        }

        return carNames
    }

    private fun getRoundCount(): Int {
        println("시도할 횟수는 몇 회인가요?")
        val input = Console.readLine()

        if (!input.matches(Regex("-?\\d+"))) {
            throw IllegalArgumentException("정수만 입력할 수 있습니다.")
        }

        return input.toIntOrNull() ?: 0
    }

    private fun findWinners(): String {
        val maxPosition = raceResults.last().maxOf { it.count { it == '-' } }
        val winners = carNames.filterIndexed { index, _ ->
            raceResults.last()[index].count { it == '-' } == maxPosition
        }
        return winners.joinToString(", ")
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