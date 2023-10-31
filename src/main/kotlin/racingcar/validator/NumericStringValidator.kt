package racingcar.validator

class NumericStringValidator() : StringValidator {
    override fun validate(target: String) {
        if (target == ZERO) throw IllegalArgumentException(ZERO_ERROR_MESSAGE)
        if (target
                .all { it.isDigit() }
                .not()
        ) throw IllegalArgumentException(NUMERIC_ERROR_MESSAGE)
    }

    companion object {
        private const val ZERO = "0"
        private const val NUMERIC_ERROR_MESSAGE = "문자열은 숫자여야 합니다"
        private const val ZERO_ERROR_MESSAGE = "0은 유효하지 않습니다"
    }
}