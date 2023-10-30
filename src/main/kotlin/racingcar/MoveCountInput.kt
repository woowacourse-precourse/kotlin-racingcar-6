package racingcar

import racingcar.ErrorMessage.INVALID_ATTEMPT_COUNT_ERROR

object MoveCountInput {
    private const val MIN_ATTEMPT_COUNT = 0

    private fun validateAttempts(attempts: Int) {
        if (attempts <= MIN_ATTEMPT_COUNT) {
            throw IllegalArgumentException(INVALID_ATTEMPT_COUNT_ERROR)
        }
    }
}
