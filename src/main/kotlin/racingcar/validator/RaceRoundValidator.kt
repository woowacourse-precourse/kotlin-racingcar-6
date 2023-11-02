package racingcar.validator

class RaceRoundValidator {
    fun validate(raceRoundString: String) {
        requireNumericString(raceRoundString)
        val raceRound = raceRoundString.toInt()
        requirePositiveNumber(raceRound)
    }

    private fun requireNumericString(string: String) {
        require(string.isNotBlank() && string.all { it.isDigit() }) { NON_NUMERIC_INPUT_ERROR_MESSAGE }
    }

    private fun requirePositiveNumber(raceRound: Int) {
        require(raceRound >= MIN_POSITIVE_NUMBER) { NON_POSITIVE_NUMBER_ERROR_MESSAGE }
    }

    companion object {
        private const val MIN_POSITIVE_NUMBER = 1
        private const val NON_NUMERIC_INPUT_ERROR_MESSAGE = "숫자가 아닌 다른 형식을 입력할 수 없습니다."
        private const val NON_POSITIVE_NUMBER_ERROR_MESSAGE = "1 이상의 숫자만 입력할 수 있습니다."
    }
}