package racingcar.validator


class StringLengthValidator() : StringValidator {
    override fun validate(target: String) = when {
        isNotInRange(target) -> throw IllegalArgumentException(LENGTH_ERROR_MESSAGE)
        isIncludeBlank(target) -> throw IllegalArgumentException(BLANK_ERROR_MESSAGE)
        else -> Unit
    }

    private fun isIncludeBlank(target: String) = target
        .split(DELIMITER)
        .any { it.isBlank() }

    private fun isNotInRange(target: String) = target
        .split(DELIMITER)
        .all { it.length in RANGE }
        .not()


    companion object {
        private const val DELIMITER = ","
        private const val MIN_LENGTH = 1
        private const val MAX_LENGTH = 5
        private val RANGE = MIN_LENGTH..MAX_LENGTH
        private const val LENGTH_ERROR_MESSAGE = "문자열의 길이가 1글자 이상 5글자 이하여야 합니다"
        private const val BLANK_ERROR_MESSAGE = "공백 문자열은 유효하지 않습니다"
    }
}