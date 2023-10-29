package racingcar.util

import racingcar.constant.Constants.MAX_NAME_LENGTH
import racingcar.constant.Constants.MIN_ATTEMPT_COUNT
import racingcar.constant.Constants.MIN_NAME_LENGTH

class Validator(carNames: ArrayList<String>, attemptCount: String) {

    init {
        isValidLengthAndAlphabetic(carNames)
        checkIfDuplicateNameExists(carNames)
        isPositiveInteger(attemptCount)
    }

    private fun isValidLengthAndAlphabetic(carNames: ArrayList<String>) {
        carNames.forEach { carName ->
            if (carName.length !in MIN_NAME_LENGTH..MAX_NAME_LENGTH || !carName.all { it.isLetter() }) {
                throw IllegalArgumentException("Car names must be alphabetic and have a length of 1 to 5 characters.")
            }
        }
    }

    private fun checkIfDuplicateNameExists(carNames: ArrayList<String>) {
        val uniqueNames = carNames.toSet()
        if (uniqueNames.size != carNames.size) {
            throw IllegalArgumentException("Car names must not be duplicated.")
        }
    }

    private fun isPositiveInteger(attemptCount: String) {
        val attemptCountInt = try {
            attemptCount.toInt()
        } catch (e: NumberFormatException) {
            throw IllegalArgumentException("Attempt count must be a positive integer.")
        }

        if (attemptCountInt <= MIN_ATTEMPT_COUNT) {
            throw IllegalArgumentException("Attempt count must be a positive integer.")
        }
    }
}
