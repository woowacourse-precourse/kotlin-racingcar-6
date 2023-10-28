package racingcar.util

class Validator(carNames: ArrayList<String>, attemptCount: String) {

    init {
        isValidLengthAndAlphabetic(carNames)
        checkIfDuplicateNameExists(carNames)
        isPositiveInteger(attemptCount)
    }

    private fun isValidLengthAndAlphabetic(carNames: ArrayList<String>) {

    }

    private fun checkIfDuplicateNameExists(carNames: ArrayList<String>) {

    }

    private fun isPositiveInteger(attemptCount: String) {

    }
}
