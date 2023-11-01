package racingcar.validation

import racingcar.util.INVALID_ATTEMPTS_NUMBER_TYPE
import racingcar.util.INVALID_CAR_NAME_LENGTH
import racingcar.util.MAX_CAR_NAME_LENGTH
import racingcar.util.MIN_CAR_NAME_LENGTH

class InputValidation {
    fun validateCarNames(names: List<String>): List<String> {
        validateCarNamesLength(names)
        return names
    }

    private fun validateCarNamesLength(names: List<String>) {
        names.forEach { name -> validateCarNameLength(name) }
    }

    private fun validateCarNameLength(name: String) {
        if (name.length !in MIN_CAR_NAME_LENGTH..MAX_CAR_NAME_LENGTH) {
            throw IllegalArgumentException(INVALID_CAR_NAME_LENGTH)
        }
    }

    fun validateAttemptsNumber(attempt: Int): Int {
        val attemptsNumber = attempt
        if (attemptsNumber >= 0) {
            return attemptsNumber
        } else {
            throw IllegalArgumentException(INVALID_ATTEMPTS_NUMBER_TYPE)
        }
    }
}