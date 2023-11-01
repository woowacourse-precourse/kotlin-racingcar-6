package racingcar.validator

class NumericStringValidator() : StringValidator {
    override fun validate(target: String) = when {
        isNotNumeric(target) -> throw IllegalArgumentException(NUMERIC_ERROR_MESSAGE)
        isZero(target) -> throw IllegalArgumentException(ZERO_ERROR_MESSAGE)
        else -> Unit
    }

    private fun isZero(target: String) = target == ZERO

    private fun isNotNumeric(target: String) = target.all { it.isDigit() }.not()

    companion object {
        private const val ZERO = "0"
        private const val NUMERIC_ERROR_MESSAGE = "문자열은 숫자여야 합니다"
        private const val ZERO_ERROR_MESSAGE = "0은 유효하지 않습니다"
    }
}