package racingcar

import racingcar.Converter.convertStringToInt
import racingcar.ErrorMessage.INVALID_ATTEMPT_COUNT_ERROR
import racingcar.ErrorMessage.NUMBER_FORMAT_ERROR

object MoveCountInput {
    private const val MIN_ATTEMPT_COUNT = 0

    fun getMoveCount(userInput: String): Int {
        return runCatching {
            convertStringToInt(userInput).apply { validateAttempts(this) }
        }.getOrElse { throwable ->
            when (throwable) {
                is NumberFormatException -> throw IllegalArgumentException(NUMBER_FORMAT_ERROR)
                else -> throw IllegalArgumentException(throwable.message)
            }
        }
    }

    private fun validateAttempts(attempts: Int) {
        if (attempts <= MIN_ATTEMPT_COUNT) {
            throw IllegalArgumentException(INVALID_ATTEMPT_COUNT_ERROR)
        }
    }
}
