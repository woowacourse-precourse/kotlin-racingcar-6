package racingcar.validator

import racingcar.utils.Converter

class MoveCountValidator {
    fun validate(moveCountString: String) {
        requireNumericString(moveCountString)
        val moveCount = Converter.convertStringToInt(moveCountString)
        requirePositiveNumber(moveCount)
    }

    private fun requireNumericString(string: String) {
        require(string.all { it.isDigit() }) { NON_NUMERIC_INPUT_ERROR_MESSAGE }
    }

    private fun requirePositiveNumber(moveCount: Int) {
        require(moveCount >= MINIMUM_POSITIVE_NUMBER) { INVALID_NON_POSITIVE_NUMBER_ERROR_MESSAGE }
    }

    companion object {
        private const val MINIMUM_POSITIVE_NUMBER = 1
        private const val NON_NUMERIC_INPUT_ERROR_MESSAGE = "숫자가 아닌 다른 형식을 입력할 수 없습니다."
        private const val INVALID_NON_POSITIVE_NUMBER_ERROR_MESSAGE = "1 이상의 숫자만 입력할 수 있습니다."
    }
}