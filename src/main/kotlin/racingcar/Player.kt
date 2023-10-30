package racingcar

import racingcar.validator.InputValidator
import racingcar.validator.NumericStringValidator
import racingcar.validator.StringValidator


class Player(
    private val reader: Reader = Reader(),
) {
    fun determineCarNames(
        input: String = reader.read(),
        validator: StringValidator = InputValidator()
    ): List<String> {
        validator.validate(input)
        return input.toCarNames()
    }

    fun determineAttemptCount(
        input: String = reader.read(),
        validator: StringValidator = NumericStringValidator()
    ): Int {
        validator.validate(input)
        return input.toInt()
    }

    private fun String.toCarNames() = this.split(DELIMITER)

    companion object {
        private const val DELIMITER = ","
    }
}