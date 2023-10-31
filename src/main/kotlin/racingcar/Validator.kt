package racingcar

import java.lang.IllegalArgumentException

class Validator {
    fun validateCarNames(carNames: String) {
        checkHasNoBlank(carNames)
        checkHasSeparator(carNames, COMMA)
        checkItemsHasNoDuplication(carNames.split(COMMA))
        checkNumericValueIsInBoundary(carNames.split(COMMA).size, MIN_CAR_NAME_COUNT)
        carNames.split(COMMA).map { carName ->
            checkNumericValueIsInBoundary(carName.length, MIN_CAR_NAME_LENGTH, MAX_CAR_NAME_LENGTH)
        }
    }

    private fun checkHasNoBlank(input: String) {
        if (input.contains(BLANK)) throw IllegalArgumentException()
    }

    private fun checkHasSeparator(input: String, separator: String) {
        if (!input.contains(separator)) throw IllegalArgumentException()
    }

    private fun <T> checkItemsHasNoDuplication(items: List<T>) {
        if (items.toSet().size != items.size) throw IllegalArgumentException()
    }

    private fun checkNumericValueIsInBoundary(number: Int, minNumber: Int = 0, maxNumber: Int = 100) {
        if (number !in minNumber..maxNumber) throw IllegalArgumentException()
    }

    fun validateTotalRoundNumber(totalRoundNumber: String) {
        checkHasNoBlank(totalRoundNumber)
        checkHasOnlyDigit(totalRoundNumber)
        checkNumericValueIsInBoundary(Integer.parseInt(totalRoundNumber), MIN_TOTAL_ROUND)
    }

    private fun checkHasOnlyDigit(input: String) {
        if (input.map { data -> Character.isDigit(data) }.contains(false)) throw IllegalArgumentException()
    }

    companion object {
        private const val BLANK = " "
        private const val COMMA = ","
        private const val MIN_CAR_NAME_LENGTH = 1
        private const val MAX_CAR_NAME_LENGTH = 5
        private const val MIN_CAR_NAME_COUNT = 2
        private const val MIN_TOTAL_ROUND = 1
    }
}