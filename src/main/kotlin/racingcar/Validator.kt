package racingcar

import java.lang.IllegalArgumentException

class Validator {

    private fun checkInputHasNoBlank(input: String) {
        if (input.contains(BLANK)) throw IllegalArgumentException()
    }

    private fun checkInputHasSeparator(input: String, separator: String) {
        if (!input.contains(separator)) throw IllegalArgumentException()
    }

    private fun checkInputLengthIsInBoundary(input: String, minLength: Int = 0, maxLength: Int = 100) {
        if (input.length !in minLength..maxLength) throw IllegalArgumentException()
    }

    private fun <T> checkItemCountsAreInBoundary(items: List<T>, minLength: Int = 0, maxLength: Int = 100) {
        if (items.size !in minLength..maxLength) throw  IllegalArgumentException()
    }

    private fun <T> checkItemsHasNoDuplication(items: List<T>) {
        if (items.toSet().size != items.size) throw IllegalArgumentException()
    }

    fun validateCarNames(input: String) {
        checkInputHasNoBlank(input)
        checkInputHasSeparator(input, COMMA)
        input.split(COMMA).map { name ->
            checkInputLengthIsInBoundary(name, MIN_CAR_NAME_LENGTH, MAX_CAR_NAME_LENGTH)
        }
        checkItemCountsAreInBoundary(input.split(COMMA), MIN_CAR_NAME_COUNT)
        checkItemsHasNoDuplication(input.split(COMMA))
    }
    
    companion object {
        private const val BLANK = " "
        private const val COMMA = ","
        private const val MIN_CAR_NAME_LENGTH = 1
        private const val MAX_CAR_NAME_LENGTH = 5
        private const val MIN_CAR_NAME_COUNT = 2
    }
}