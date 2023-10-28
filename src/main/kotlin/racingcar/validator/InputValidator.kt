package racingcar.validator

class InputValidator {
    companion object {
        private const val EMPTY_LIST_MESSAGE = "배열이 비어 있습니다."
        private const val NOT_POSITIVE_INT_MESSAGE = "양수가 아닙니다."
    }

    fun validateCarNameList(carNameList: List<String>) {
        require(carNameList.isEmpty()) { EMPTY_LIST_MESSAGE }
    }

    fun validatePlayCount(playCount: Int) {
        require(playCount > 0) { NOT_POSITIVE_INT_MESSAGE }
    }
}