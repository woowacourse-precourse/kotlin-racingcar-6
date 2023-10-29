package racingcar.validator

import racingcar.utils.Constants
import racingcar.utils.Converter

class MoveCountValidator {
    fun validate(stringMoveCount: String) {
        requireNumericString(stringMoveCount)
        val moveCount = Converter.convertStringToInt(stringMoveCount)
        requirePositiveNumber(moveCount)
    }

    private fun requireNumericString(stringMoveCount: String) {
        require(stringMoveCount.all { it.isDigit() }) {Constants.NON_NUMERIC_INPUT_ERROR_MESSAGE}
    }

    private fun requirePositiveNumber(moveCount: Int) {
        require(moveCount >= Constants.MINIMUM_POSITIVE_NUMBER) { Constants.INVALID_NON_POSITIVE_NUMBER_ERROR_MESSAGE }
    }
}