package racingcar.utils

object Converter {
    fun splitByCommaToStringList(carNames: String): List<String> {
        return carNames.split(",").toList()
    }
}