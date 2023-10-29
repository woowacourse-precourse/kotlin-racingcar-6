package racingcar.validator

import racingcar.utils.Converter

class MoveCountValidator {
    fun validate(stringMoveCount: String) {
        val moveCount = Converter.convertStringToInt(stringMoveCount)
        requirePositiveNumber(moveCount)
    }
    private fun requirePositiveNumber(moveCount :Int) {
        require(moveCount >= 1) {"1 이상의 숫자만 입력할 수 있습니다."}
    }
}