package racingcar.validator

class NumericStringValidator() : StringValidator {
    override fun validate(target: String) {
        if (target
                .all { it.isDigit() }
                .not()
        ) throw IllegalArgumentException(ERROR_MESSAGE)
    }

    companion object {
        private const val ERROR_MESSAGE = "문자열은 숫자여야 합니다"
    }
}