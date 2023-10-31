package racingcar.validator


class StringLengthValidator() : StringValidator {
    override fun validate(target: String) {
        if (target
                .split(DELIMITER)
                .any { it.length in MIN_LENGTH..MAX_LENGTH }
        ) throw IllegalArgumentException(ERROR_MESSAGE)
    }

    companion object {
        private const val DELIMITER = ","
        private const val MIN_LENGTH = 1
        private const val MAX_LENGTH = 5
        private const val ERROR_MESSAGE = "Car 이름의 길이가 1글자 이상 5글자 이하여야 합니다"
    }
}