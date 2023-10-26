package racingcar.util

import racingcar.constant.ErrorMessage

class CarNameValidator {
    fun validateCarNamesLength(carNames: List<String>) {
        require(carNames.none{ it.length > MAX_NAME_LENGTH}) { ErrorMessage.NAME_LENGTH_GREATER_THAN_FIVE }
    }

    companion object {
        private const val MAX_NAME_LENGTH = 5
    }
}