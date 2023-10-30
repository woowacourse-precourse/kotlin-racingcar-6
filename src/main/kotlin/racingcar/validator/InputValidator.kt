package racingcar.validator

class InputValidator {
    enum class ErrorMessages(val text: String) {
        EMPTY_LIST("배열이 비어 있습니다."),
        NOT_POSITIVE_INT("양수가 아닙니다.")
    }

    fun validateCarNameList(carNameList: List<String>) =
        require(carNameList.isNotEmpty()) { ErrorMessages.EMPTY_LIST.text }

    fun validatePlayCount(playCount: Int) = require(playCount > 0) { ErrorMessages.NOT_POSITIVE_INT.text }
}