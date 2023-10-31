package racingcar.round

class RoundValidation {
    fun checkRoundInputValidation(input: String) {
        checkIsNumber(input)
        checkIsBiggerThanOne(input)
    }

    private fun checkIsNumber(input: String) {
        if (input.toIntOrNull() == null) {
            throw IllegalArgumentException("입력값은 숫자여야 합니다.")
        }
    }

    private fun checkIsBiggerThanOne(input: String) {
        if (input.toInt() < 1) {
            throw IllegalArgumentException("입력값은 1보다 큰 값이어야 합니다.")
        }
    }
}