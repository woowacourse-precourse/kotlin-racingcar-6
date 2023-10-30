package racingcar.validator


class InputValidator() : StringValidator {
    override fun validate(target: String) {
        if (target
                .split(DELIMITER)
                .any { it.length > MAX_LENGTH }
        ) throw IllegalArgumentException(ERROR_MESSAGE)
    }

    companion object {
        private const val DELIMITER = ","
        private const val MAX_LENGTH = 5
        private const val ERROR_MESSAGE = "Car 이름이 5글자 이하여야 합니다"
    }
}