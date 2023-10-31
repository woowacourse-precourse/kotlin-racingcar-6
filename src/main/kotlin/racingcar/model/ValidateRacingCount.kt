package racingcar.model

class ValidateRacingCount {

    companion object {
        const val MIN_RACING_COUNT = 1
        const val MAX_RACING_COUNT = 10
    }

    private val multiRacingGame = MultiRacingGame()

    fun validateTryCount(tryCount: String, multiCarName: List<String?>) {
        when (true) {
            validateNullOrBlank(tryCount) -> throw IllegalArgumentException("시도할 횟수를 반드시 입력해야 합니다.")

            validateNotNum(tryCount) -> throw IllegalArgumentException("시도할 횟수는 1부터 10 사이로만 입력 가능합니다.")

            validateNotInRange(tryCount) -> throw IllegalArgumentException("시도할 횟수는 1부터 10 사이로만 입력 가능합니다.")

            else -> multiRacingGame.multiRacingGame(tryCount.toInt(), multiCarName)
        }
    }

    private fun validateNotNum(tryCount: String?): Boolean {
        return tryCount!!.toIntOrNull() == null
    }

    private fun validateNotInRange(tryCount: String?): Boolean {
        return tryCount!!.toInt() !in MIN_RACING_COUNT..MAX_RACING_COUNT
    }

    private fun validateNullOrBlank(tryCount: String?): Boolean {
        return tryCount.isNullOrBlank()
    }
}
