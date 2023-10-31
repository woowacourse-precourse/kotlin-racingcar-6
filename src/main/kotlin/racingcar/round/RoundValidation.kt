package racingcar.round

class RoundValidation {
    fun checkRoundInputValidation(input: String) {
        checkIsNumber(input)
        checkIsBiggerThanOne(input)
    }

    private fun checkIsNumber(input: String) {
        if (input.toIntOrNull() == null) {
            throw IllegalArgumentException(NUMBER_INPUT_ERROR)
        }
    }

    private fun checkIsBiggerThanOne(input: String) {
        if (input.toInt() < MIN_ROUND) {
            throw IllegalArgumentException(MIN_ROUND_ERROR)
        }
    }

    companion object {
        const val MIN_ROUND = 1
        const val NUMBER_INPUT_ERROR = "입력값은 숫자여야 합니다."
        const val MIN_ROUND_ERROR = "입력값은 1보다 큰 값이어야 합니다."
    }
}