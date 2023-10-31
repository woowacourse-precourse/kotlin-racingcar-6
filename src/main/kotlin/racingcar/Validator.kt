package racingcar

object Validator {
    private const val DUPLICATE_NAME_ERROR_MSG = "Duplicate car names are not allowed."
    private const val NAME_OVER_LENGTH_MSG =
        "Car name exceeds the maximum allowed length of ${Constants.CAR_NAME_MAX_LENGTH}."
    private const val NAME_EMPTY_MSG = "Car name cannot be empty."
    private const val INVALID_NUMBER_FORMAT_MSG =
        "Invalid format for number of attempts. Please use the specified format."

    fun isCarNameUnique(carList: List<String>) {
        if (carList.size != carList.toSet().size) throw IllegalArgumentException(DUPLICATE_NAME_ERROR_MSG)
    }

    fun isCarNameLengthValid(carName: String) {
        if (carName.length > Constants.CAR_NAME_MAX_LENGTH) throw IllegalArgumentException(NAME_OVER_LENGTH_MSG)
    }

    fun isCarNameNotEmpty(carName: String) {
        if (carName.trim().isEmpty()) throw IllegalArgumentException(NAME_EMPTY_MSG)
    }

    fun isNumberAttemptsValid(numberAttempts: String) {
        if (!(numberAttempts.all { it.isDigit() }) || numberAttempts.toInt() < 1) throw IllegalArgumentException(
            INVALID_NUMBER_FORMAT_MSG
        )
    }
}