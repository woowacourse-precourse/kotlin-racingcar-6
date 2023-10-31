package racingcar

class Validator {
    fun containsComma(inputString: String) {
        if (!inputString.contains(','))
            throw IllegalArgumentException("invalid input string, there are another special characters")
    }

    fun validateNames(carsNames: List<String>) {
        for (name in carsNames) {
            isNull(name)
            
        }
    }

    private fun isNull(name: String) {
        if (name.isNullOrEmpty()) {
            throw IllegalArgumentException("invalid car's name, name is null or empty")
        }
    }
}