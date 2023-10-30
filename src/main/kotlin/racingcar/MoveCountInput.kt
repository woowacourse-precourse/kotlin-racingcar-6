package racingcar

import racingcar.Converter.convertStringToInt
import racingcar.ErrorMessage.INVALID_ATTEMPT_COUNT_ERROR
import racingcar.ErrorMessage.NUMBER_FORMAT_ERROR
import racingcar.GameMessage.INPUT_NUMBER_ATTEMPTS_MESSAGE
import racingcar.UserInput.getUserInput

object MoveCountInput {
    private const val MIN_ATTEMPT_COUNT = 0

    fun getMoveCount(): Int {
        println(INPUT_NUMBER_ATTEMPTS_MESSAGE)
        val userInput = getUserInput()
        return runCatching {
            convertStringToInt(userInput).apply { validateAttempts(this) }
        }.getOrElse { throwable ->
            when (throwable) {
                is NumberFormatException -> throw IllegalArgumentException(NUMBER_FORMAT_ERROR)
                else -> throw IllegalArgumentException(throwable)
            }
        }
    }

    private fun validateAttempts(attempts: Int) {
        if (attempts <= MIN_ATTEMPT_COUNT) {
            throw IllegalArgumentException(INVALID_ATTEMPT_COUNT_ERROR)
        }
    }
}
