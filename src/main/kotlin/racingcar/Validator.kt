package racingcar

class Validator {
    fun containsComma(inputString: String) {
        if (!inputString.contains(','))
            throw IllegalArgumentException("invalid input string, there are another special characters")
    }
}