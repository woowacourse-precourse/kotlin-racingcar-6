package racingcar.util

class Validator(carNames: ArrayList<String>, attemptCount: String) {

    init {
        isValidLengthAndAlphabetic(carNames)
        checkIfDuplicateNameExists(carNames)
        isPositiveInteger(attemptCount)
    }

    fun isValidLengthAndAlphabetic(carNames: ArrayList<String>) {

    }

    fun checkIfDuplicateNameExists(carNames: ArrayList<String>) {

    }

    fun isPositiveInteger(attemptCount: String) {

    }
}
