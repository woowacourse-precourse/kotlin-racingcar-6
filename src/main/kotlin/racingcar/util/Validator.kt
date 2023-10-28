package racingcar.util

class Validator(carNames: ArrayList<String>, attemptCount: String) {

    init {
        isValidLengthAndAlphabetic(carNames)
        checkIfDuplicateNameExists(carNames)
        isPositiveInteger(attemptCount)
    }

    private fun isValidLengthAndAlphabetic(carNames: ArrayList<String>) {
        carNames.forEach { carName ->
            if (carName.length !in 1..5 || !carName.all { it.isLetter() }) {
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

        if (attemptCountInt <= 0) {
            throw IllegalArgumentException("Attempt count must be a positive integer.")
        }
    }
}
