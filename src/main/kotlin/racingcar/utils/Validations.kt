package racingcar.utils

import racingcar.utils.Constants.ERROR_IS_EMPTY
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

        if(num.isEmpty()) {
            throw IllegalArgumentException(ERROR_IS_EMPTY)
        }
        return result
    }

    fun inputCarName(name: String): String {
        val names = name.split(",")
        for(i in names.indices) {
            if(names[i].length > 5) {
                throw IllegalArgumentException(ERROR_MAX_STRING)
            }
            if(names[i].isEmpty()) {
                throw IllegalArgumentException(ERROR_IS_EMPTY)
            }
        }
        return name
    }
}