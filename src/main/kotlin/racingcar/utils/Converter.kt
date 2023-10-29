package racingcar.utils

import java.lang.NumberFormatException

object Converter {
    fun splitByCommaToStringList(string: String): List<String> {
        return string.split(",").toList()
    }

    fun convertStringToInt(string: String): Int {
        try {
            return string.toInt()
        }
        catch (e:NumberFormatException) {
            throw IllegalArgumentException("숫자가 아닌 다른 형식을 입력할 수 없습니다.")
        }
    }
}