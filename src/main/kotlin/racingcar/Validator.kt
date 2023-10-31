package racingcar

class Validator {
    fun validateInputString(inputString: String) {
        if (!inputString.contains(','))
            throw IllegalArgumentException("invalid input string, there is no comma")
        if (inputString.contains(' '))
            throw IllegalArgumentException("invalid input string, it contains blank")
    }

    fun validateNames(carsNames: List<String>) {
        for (name in carsNames) {
            isNull(name)
            underFiveLength(name)
        }
    }

    private fun isNull(name: String) {
        if (name.isNullOrEmpty()) {
            throw IllegalArgumentException("invalid car's name, name is null or empty")
        }
    }

    private fun underFiveLength(name: String) {
        if (name.length > 5){
            throw IllegalArgumentException("invalid car's name, length of name is over 5")
        }
    }
}