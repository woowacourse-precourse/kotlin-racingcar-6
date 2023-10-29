package racingcar

object Validator {
    fun checkInputNonBlank(inputData: String) {
        require(inputData.isNotBlank()) {
            Message.VALID_INPUT_NOT_BLANK.message
        }
    }

    fun checkInputOverSize(inputSize: Int) {
        require(inputSize < 11) {
            Message.VALID_INPUT_OVER_SIZE.message
        }
    }
}