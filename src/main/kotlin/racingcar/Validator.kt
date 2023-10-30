package racingcar

import java.lang.IllegalArgumentException

class Validator {

    fun validateCarNames(input: String) {
        checkCarNameBlank(input)
        checkCarNameSeparator(input)
        checkCarNameLength(input)
        checkCarNameCount(input)
        checkCarNameDistinction(input)
    }

    private fun checkCarNameBlank(input: String) {
        if (input.contains(BLANK)) throw IllegalArgumentException()
    }

    private fun checkCarNameSeparator(input: String) {
        if (!input.contains(COMMA)) throw IllegalArgumentException()
    }

    private fun checkCarNameLength(input: String) {
        val carNames = input.split(COMMA)
        val isCarNameInRange = carNames.map { name -> name.length in MIN_NAME_LENGTH..MAX_NAME_LENGTH }

        if (isCarNameInRange.contains(false)) throw IllegalArgumentException()
    }

    private fun checkCarNameCount(input: String) {
        val carNames = input.split(COMMA)

        if (carNames.size < MIN_NAME_COUNT) throw IllegalArgumentException()
    }

    private fun checkCarNameDistinction(input: String) {
        val carNames = input.split(COMMA)

        if (carNames.toSet().size != carNames.size) throw IllegalArgumentException()
    }

    companion object {
        private const val BLANK = " "
        private const val COMMA = ","
        private const val MIN_NAME_LENGTH = 1
        private const val MAX_NAME_LENGTH = 5
        private const val MIN_NAME_COUNT = 2
    }
}