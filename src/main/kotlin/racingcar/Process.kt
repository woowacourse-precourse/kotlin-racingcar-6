package racingcar

object Process {
    private val validation = Validation()
    private lateinit var carNames: List<String>
    private var attemptTimes: Int = 0
    private lateinit var round: Round

    fun generateCars(input: String) {
        carNames = validation.validateCarNames(input.split(",").map { it.trim() })
        round = Round(carNames)
        round.initializeAndGetCars(carNames)
    }

    fun setAttemptTimes(input: String) {
        attemptTimes = validation.getAttemptTimes(input)
    }

    fun getRound(): Round {
        return round
    }

    fun playRound() {
        for (i in 1..attemptTimes) {
            round.move()
            round.printRound()
        }
    }

    fun getWinners(): List<String> {
        return round.getWinners()
    }
}

class Validation {
    fun validateCarNames(carNamesInput: List<String>): List<String> {
        return carNamesInput.apply {
            forEach {
                require(it.isNotBlank()) { "자동차 이름을 입력해주세요." }
                require(it.length <= 5) { "이름은 5자 이하로 입력해주세요." }
            }
        }
    }

    fun getAttemptTimes(attemptTimes: String): Int =
        attemptTimes.toIntOrNull() ?: throw IllegalArgumentException("시도 횟수를 입력해주세요.")
}