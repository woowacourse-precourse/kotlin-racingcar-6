package racingcar.util

import racingcar.constant.ErrorMessage

class AttemptCountValidator {
    fun isNumberFormat(userChoice: String) {
        require(userChoice.none { char -> !char.isDigit() }) { ErrorMessage.NOT_NUMBER.message }
    }
}