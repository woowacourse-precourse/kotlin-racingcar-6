package racingcar.utils

object StringListSplitter {
    fun splitByCommaToStringList(string: String): List<String> {
        return string.split(",").toList()
    }
}