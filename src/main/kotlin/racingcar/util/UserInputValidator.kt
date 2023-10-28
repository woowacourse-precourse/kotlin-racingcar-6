package racingcar.util

import racingcar.constant.ErrorMessage
import racingcar.constant.ExtraText

class UserInputValidator {
    fun validateNumberFormat(userChoice: String) {
        require(userChoice.none { char -> !char.isDigit() }) { ErrorMessage.NOT_NUMBER.message }
    }

    fun validateCarNames(carNames: List<String>) {
        require(isNotBlankName(carNames)) { ErrorMessage.NOT_EMPTY_NAMES.message }
        require(isNotContainBlank(carNames)) { ErrorMessage.NOT_CONTAINS_BLANK_IN_NAME.message }
    }

    private fun isNotBlankName(carNames: List<String>): Boolean {
        carNames.forEach { name ->
            if (name.isBlank()) {
                return false
            }
        }
        return true
    }

    private fun isNotContainBlank(carNames: List<String>): Boolean {
        return carNames.none { it.first() == ExtraText.BLANK.text || it.last() == ExtraText.BLANK.text }
    }
}