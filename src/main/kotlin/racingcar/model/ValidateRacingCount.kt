package racingcar.model

class ValidateRacingCount {

    companion object {
        const val MIN_RACING_COUNT = 1
        const val MAX_RACING_COUNT = 10
    }

    private val multiRacingGame = MultiRacingGame()

    fun validateTryCount(tryCount: String, multiCarName: List<String?>) {
        when (true) {
            validateNullOrBlank(tryCount) -> throw IllegalArgumentException() // NO_TRY_COUNT

            validateNotInRange(tryCount) -> throw IllegalArgumentException() // TRY_COUNT_RANGE

            validateNotNum(tryCount) -> throw IllegalArgumentException() // NOT_DIGIT_COUNT

            else -> multiRacingGame.multiRacingGame(tryCount.toInt(), multiCarName)
        }
    }

    private fun validateNullOrBlank(tryCount: String?): Boolean {
        return tryCount.isNullOrBlank()
    }

    private fun validateNotNum(tryCount: String?): Boolean {
        return tryCount!!.toIntOrNull() == null
    }

    private fun validateNotInRange(tryCount: String?): Boolean {
        return tryCount!!.toInt() !in MIN_RACING_COUNT..MAX_RACING_COUNT
    }
}
