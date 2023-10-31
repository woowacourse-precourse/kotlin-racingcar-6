package racingcar.model

import racingcar.views.OutputView

class ValidateRacingCount {

    companion object {
        const val MIN_RACING_COUNT = 1
        const val MAX_RACING_COUNT = 10
    }

    fun validateTryCount(tryCount: String): Int {
        when (true) {
            validateNullOrBlank(tryCount) -> throw IllegalArgumentException(OutputView.NO_TRY_COUNT_ERROR)

            validateNotInRange(tryCount) -> throw IllegalArgumentException(OutputView.TRY_COUNT_RANGE_ERROR)

            validateNotNum(tryCount) -> throw IllegalArgumentException(OutputView.NOT_DIGIT_TRY_COUNT_ERROR)

            else -> return tryCount.toInt()
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
