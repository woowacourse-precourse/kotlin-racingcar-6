package racingcar.utils

import java.lang.NumberFormatException

object Converter {
    fun splitByCommaToStringList(string: String): List<String> {
        return string.split(Constants.COMMA).toList()
    }

    fun convertStringToInt(string: String): Int {
        try {
            return string.toInt()
        }
        catch (e:NumberFormatException) {
            throw IllegalArgumentException(Constants.NON_NUMERIC_INPUT_ERROR_MESSAGE)
        }
    }
}