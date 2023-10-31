package racingcar

import java.lang.IllegalArgumentException

class Validator {

    fun checkHasNoBlank(input: String) {
        if (input.contains(BLANK)) throw IllegalArgumentException()
    }

    fun checkHasSeparator(input: String, separator: String) {
        if (!input.contains(separator)) throw IllegalArgumentException()
    }

    fun checkHasOnlyDigit(input: String) {
        if (input.map { data -> Character.isDigit(data) }.contains(false)) throw IllegalArgumentException()
    }

    fun <T> checkItemsHasNoDuplication(items: List<T>) {
        if (items.toSet().size != items.size) throw IllegalArgumentException()
    }

    fun checkNumericValueIsInBoundary(number: Int, minNumber: Int = 0, maxNumber: Int = 100) {
        if (number !in minNumber..maxNumber) throw IllegalArgumentException()
    }

    companion object {
        private const val BLANK = " "
    }
}