package racingcar

class Validator {
    fun validateString(inputString: String) {
        if (!inputString.contains(','))
            throw IllegalArgumentException("invalid input string, there are another special characters")
    }
}