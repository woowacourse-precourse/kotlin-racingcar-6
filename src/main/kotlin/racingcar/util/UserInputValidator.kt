package racingcar.util

import racingcar.constant.ErrorMessage
import racingcar.constant.ExtraChar

class UserInputValidator {
    fun validateNumberFormat(userAttemptCount: String) {
        require(userAttemptCount.none { char -> !char.isDigit() }) { ErrorMessage.NOT_NUMBER.message }
        require(userAttemptCount.toInt() >= MIN_ATTEMPT_COUNT) { ErrorMessage.NOT_POSITIVE_NUMBER.message }
    }


    fun validateCarNames(carNames: List<String>) {
        require(isNotBlankName(carNames)) { ErrorMessage.NOT_EMPTY_NAMES.message }
        require(isNotContainBlank(carNames)) { ErrorMessage.NOT_CONTAINS_BLANK_IN_NAME.message }
    }

    private fun isNotBlankName(carNames: List<String>): Boolean {
        return carNames.none { it.isBlank() }
    }

    private fun isNotContainBlank(carNames: List<String>): Boolean {
        return carNames.none { it.first() == ExtraChar.BLANK.text || it.last() == ExtraChar.BLANK.text }
    }

    companion object {
        private const val MIN_ATTEMPT_COUNT = 1
    }
}