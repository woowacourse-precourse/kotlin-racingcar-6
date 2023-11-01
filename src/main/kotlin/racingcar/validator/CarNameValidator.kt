package racingcar.validator

import racingcar.utils.StringListSplitter

class CarNameValidator {
    fun validate(carNames: String) {
        val nameList = StringListSplitter.splitByCommaToStringList(carNames)
        requireNoBlankName(nameList)
        requireNameLengthInRange(nameList)
        requireNoDuplicatedName(nameList)
    }

    private fun requireNoBlankName(names: List<String>) {
        require(names.all { it.isNotBlank() }) { NAME_CONTAINS_WHITESPACE_ERROR_MESSAGE }
    }

    private fun requireNameLengthInRange(names: List<String>) {
        require(names.all { it.length <= MAX_NAME_LENGTH }) { INVALID_NAME_LENGTH_ERROR_MESSAGE }
    }

    private fun requireNoDuplicatedName(names: List<String>) {
        val uniqueNames = names.toSet()
        require(names.size == uniqueNames.size) { DUPLICATE_NAME_INPUT_ERROR_MESSAGE }
    }

    companion object {
        private const val MAX_NAME_LENGTH = 5
        private const val NAME_CONTAINS_WHITESPACE_ERROR_MESSAGE = "이름에 공백을 입력할 수 없습니다."
        private const val INVALID_NAME_LENGTH_ERROR_MESSAGE = "이름은 다섯 자 이하로 입력해야 합니다."
        private const val DUPLICATE_NAME_INPUT_ERROR_MESSAGE = "중복된 이름을 입력할 수 없습니다."
    }
}