package racingcar

object Validator {
    fun isCarNameUnique(carList: List<String>) {
        if (carList.size != carList.toSet().size) throw IllegalArgumentException("Duplicate car names are not allowed.")
    }

    fun isCarNameLengthValid(carName: String) {
        if (carName.length > Constants.CAR_NAME_MAX_LENGTH) throw IllegalArgumentException("Car name cannot be empty.")
    }

    fun isCarNameNotEmpty(carName: String) {
        if (carName.trim()
                .isEmpty()
        ) throw IllegalArgumentException("Car name '$carName' exceeds the maximum allowed length of ${Constants.CAR_NAME_MAX_LENGTH}.")
    }

    fun isNumberAttemptsValid(numberAttempts: String) {
        if (!(numberAttempts.all { it.isDigit() }) || numberAttempts.toInt() < 1) throw IllegalArgumentException("Invalid format for number of attempts. Please use the specified format.")
    }
}