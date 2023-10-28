package racingcar.validator

class CarNameValidator {

    fun validateCarNames(carNames: String): List<String>{
        val carNameList = splitAndTrimToStringList(carNames)
        return carNameList
    }

    private fun splitAndTrimToStringList(carNames: String): List<String> {
        return carNames.split(",").map { it.trim() }
    }
}