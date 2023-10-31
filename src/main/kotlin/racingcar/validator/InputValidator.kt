package racingcar.validator

import racingcar.Message

object InputValidator {
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

    fun checkInputWhitespace(input: String) {
        require(input != "") {
            Message.VALID_INPUT_WHITESPACE.message
        }
    }

    fun checkCarNameLength(input: String) {
        require(input.length in 1..5) {
            Message.VALID_INPUT_LENGTH.message
        }
    }

    fun checkCarMinSize(input: String) {
        require(input.split(",").size != 1) {
            Message.VALID_INPUT_MIN_SIZE.message
        }
    }

    fun checkInputPrefix(first: Char) {
        require(first != ',') {
            Message.VALID_INPUT_PREFIX.message
        }
    }

    fun checkInputPostfix(last: Char) {
        require(last != ',') {
            Message.VALID_INPUT_POSTFIX.message
        }
    }

    fun checkGameRoundSize(round: Int) {
        require(round in 1..50) {
            Message.VALID_ROUND_SIZE.message
        }
    }

    fun checkIntType(round: String) {
        require(round.none { it.isLetter() }) {
            Message.VALID_ROUND_NOT_INTEGER.message
        }
    }
}