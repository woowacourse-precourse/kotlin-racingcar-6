package racingcar.util

import racingcar.constant.ErrorMessage

class UserInputValidator {
    fun validateNumberFormat(userChoice: String) {
        require(userChoice.none { char -> !char.isDigit() }) { ErrorMessage.NOT_NUMBER.message }
    }

    fun validateCarNames(carNames: List<String>) {
        require(carNames.isNotEmpty()) { ErrorMessage.NOT_EMPTY_NAMES.message }
    }
}