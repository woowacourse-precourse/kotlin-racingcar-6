package racingcar.validator

import racingcar.utils.Converter
import racingcar.utils.Constants

class CarNameValidator {
    fun validate(carNames: String) {
        val carNameList = Converter.splitByCommaToStringList(carNames)

        requireNoBlankName(carNameList)
        requireNameLengthInRange(carNameList)
        requireNoDuplicatedName(carNameList)
    }

    private fun requireNoBlankName(carNameList: List<String>) {
        require(carNameList.all { it.isNotBlank() }) { Constants.NAME_CONTAINS_WHITESPACE_ERROR_MESSAGE }
    }

    private fun requireNameLengthInRange(carNameList: List<String>) {
        require(carNameList.all { it.length <= Constants.MAX_CAR_NAME_LENGTH }) { Constants.INVALID_NAME_LENGTH_MESSAGE }
    }

    private fun requireNoDuplicatedName(carNameList: List<String>) {
        val carNameSet = carNameList.toHashSet()
        require(carNameList.size == carNameSet.size) { Constants.DUPLICATE_NAME_INPUT_ERROR_MESSAGE }
    }
}