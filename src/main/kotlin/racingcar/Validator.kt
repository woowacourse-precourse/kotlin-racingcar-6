package racingcar

object Validator {
    fun checkInputNonBlank(inputData: String) {
        require(inputData.isNotBlank()) {
            Message.VALID_INPUT_NOT_BLANK
        }
    }
}