package racingcar.utils

import racingcar.utils.Constants.ERROR_MAX_STRING
import racingcar.utils.Constants.ERROR_STRING_TYPE

object Validations {
    fun inputTrial(num: String): Int {
        val result: Int
        try {
            result = num.toInt()
        } catch (e: NumberFormatException) {
            throw IllegalArgumentException(ERROR_STRING_TYPE)
        }
        return result
    }

    fun inputCarName(name: String): String {
        val names = name.split(",")
        for(i in 0 until names.size) {
            if(names[i].length > 5) {
                throw IllegalArgumentException(ERROR_MAX_STRING)
            }
        }
        return  name
    }
}