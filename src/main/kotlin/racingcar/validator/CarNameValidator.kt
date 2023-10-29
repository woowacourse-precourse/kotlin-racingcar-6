package racingcar.validator

import racingcar.utils.Converter

class CarNameValidator {
    fun validate(carNames: String) {
        val carNameList = Converter.splitByCommaToStringList(carNames)

        requireNoBlanckName(carNameList)
        requireNameLengthInRange(carNameList)
        requireNoDuplicatedName(carNameList)
    }

    private fun requireNoBlanckName(carNameList: List<String>) {
        require(carNameList.all { it.isNotBlank() }) { "이름에 공백을 입력할 수 없습니다." }
    }

    private fun requireNameLengthInRange(carNameList: List<String>) {
        require(carNameList.all { it.length <= 5 }) { "이름은 다섯 자 이하로 입력해야 합니다." }
    }

    private fun requireNoDuplicatedName(carNameList: List<String>) {
        val carNameSet = carNameList.toHashSet()
        require(carNameList.size == carNameSet.size) { "중복된 이름을 입력할 수 없습니다." }
    }
}