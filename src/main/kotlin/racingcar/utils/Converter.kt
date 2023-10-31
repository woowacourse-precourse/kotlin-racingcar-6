package racingcar.utils

object Converter {
    fun splitByCommaToStringList(string: String): List<String> {
        return string.split(",").toList()
    }

    fun convertStringToInt(string: String): Int {
        return string.toInt()
    }
}