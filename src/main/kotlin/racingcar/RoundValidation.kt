package racingcar

class RoundValidation {
    fun checkRoundInputValidation(input: String) {
        checkIsNumber(input)
    }

    private fun checkIsNumber(input: String) {
        if (input.toIntOrNull() == null) {
            throw IllegalArgumentException("입력값은 숫자여야 합니다.")
        }
    }
}