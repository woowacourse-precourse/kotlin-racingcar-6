package racingcar.validator

class NumericStringValidator() : StringValidator {
    override fun validate(target: String) {
        if (target
                .all { it.isDigit() }
                .not()
        ) throw IllegalArgumentException(ERROR_MESSAGE)
    }

    companion object {
        private const val ERROR_MESSAGE = "시도 횟수는 숫자여야 합니다"
    }
}