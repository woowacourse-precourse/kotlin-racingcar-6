package racingcar

import camp.nextstep.edu.missionutils.Console

object Process {
    private val validation = Validation()
    private lateinit var carNames: List<String>
    private var attemptTimes: Int = 0
    private lateinit var round: Round

    fun generateCars() {
        val input = Console.readLine()
        carNames = validation.validateCarNames(input.split(",").map { it.trim() })
        round = Round(carNames)
    }

    fun getAttemptTimes() {
        val input = Console.readLine()
        attemptTimes = validation.getAttemptTimes(input)
    }


    class Validation {
        fun validateCarNames(carNamesInput: List<String>): List<String> {
            return carNamesInput.apply {
                forEach {
                    require(it.isNotBlank())
                    require(it.length <= 5)
                }
            }
        }

        fun getAttemptTimes(attemptTimes: String): Int =
            attemptTimes.toIntOrNull() ?: throw IllegalArgumentException()
    }
}


