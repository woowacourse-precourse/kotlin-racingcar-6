package racingcar.validator

class CarNameValidator {

    fun validateCarNames(carNames: String): List<String> {
        val carNameList = splitAndTrimToStringList(carNames)

        if (isEmptyName(carNameList)) throw IllegalArgumentException("이름에 공백을 입력할 수 없습니다.")
        if (isCorrectNameLengthInRange(carNameList)) throw IllegalArgumentException("이름은 다섯 자 이하로 입력해야 합니다.")
        if (isDuplicatedName(carNameList)) throw IllegalArgumentException("중복된 이름을 입력할 수 없습니다.")
        return carNameList
    }

    private fun splitAndTrimToStringList(carNames: String): List<String> {
        return carNames.split(",").map { it.trim() }
    }

    private fun isEmptyName(carNameList: List<String>): Boolean {
        return carNameList.any { it.isEmpty() }
    }

    private fun isCorrectNameLengthInRange(carNameList: List<String>): Boolean {
        return carNameList.any { it.length > 5 }
    }

    private fun isDuplicatedName(carNameList: List<String>): Boolean {
        return carNameList.size != carNameList.toHashSet().size
    }
}