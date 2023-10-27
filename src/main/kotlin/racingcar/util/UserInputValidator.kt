package racingcar.util

import racingcar.constant.ErrorMessage
import racingcar.constant.ExtraText

class UserInputValidator {
    fun validateNumberFormat(userChoice: String) {
        require(userChoice.none { char -> !char.isDigit() }) { ErrorMessage.NOT_NUMBER.message }
    }

    fun validateCarNames(carNames: List<String>) {
        require(isNotBlankName(carNames)) { ErrorMessage.NOT_EMPTY_NAMES.message }
        require(carNames.all { it.none { char -> char.isDigit() } }) { ErrorMessage.NOT_CONTAINS_NUMBER_IN_NAME.message }
        require(carNames.none { it.contains(ExtraText.BLANK.text) }) { ErrorMessage.NOT_CONTAINS_BLANK_IN_NAME.message }
    }

    private fun isNotBlankName(carNames: List<String>): Boolean {
        carNames.forEachIndexed { index, name ->
            println(name)
            if (name.isBlank() && index != carNames.lastIndex) {
                return false
            }
        }
        return true
    }
}