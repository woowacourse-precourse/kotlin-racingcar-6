package racingcar.validator


class StringLengthValidator() : StringValidator {
    override fun validate(target: String) {
        if (target
                .split(DELIMITER)
                .any { it.isBlank() }
        ) throw IllegalArgumentException(BLANK_ERROR_MESSAGE)
        if (target
                .split(DELIMITER)
                .all { it.length in MIN_LENGTH..MAX_LENGTH }
                .not()
        ) throw IllegalArgumentException(LENGTH_ERROR_MESSAGE)
    }

    companion object {
        private const val DELIMITER = ","
        private const val MIN_LENGTH = 1
        private const val MAX_LENGTH = 5
        private const val LENGTH_ERROR_MESSAGE = "문자열의 길이가 1글자 이상 5글자 이하여야 합니다"
        private const val BLANK_ERROR_MESSAGE = "공백 문자열은 유효하지 않습니다"
    }
}