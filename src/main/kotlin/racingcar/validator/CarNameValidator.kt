package racingcar.validator

class CarNameValidator {
    fun validate(carNames: String) {
        val carNameList = splitByCommaAndTrimToStringList(carNames)

        requireNoEmptyName(carNameList)
        requireNameLengthInRange(carNameList)
        requireNoDuplicatedName(carNameList)
    }

    private fun splitByCommaAndTrimToStringList(carNames: String): List<String> {
        return carNames.split(",").map { it.trim() }
    }

    private fun requireNoEmptyName(carNameList: List<String>) {
        require(carNameList.all { it.isNotEmpty() }) { "이름에 공백을 입력할 수 없습니다." }
    }

    private fun requireNameLengthInRange(carNameList: List<String>) {
        require(carNameList.all { it.length <= 5 }) { "이름은 다섯 자 이하로 입력해야 합니다." }
    }

    private fun requireNoDuplicatedName(carNameList: List<String>) {
        val carNameSet = carNameList.toHashSet()
        require(carNameList.size == carNameSet.size) { "중복된 이름을 입력할 수 없습니다." }
    }
}