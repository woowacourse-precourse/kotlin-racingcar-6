package racingcar.util

import racingcar.util.Constants.EXCEPTION_WRONG_LENGTH

object Validation {

    fun validateLength(str: String): String {
        val name = str.replace(" ", "")
        if (name.length in 1..5) {
            return name
        } else {
            throw IllegalArgumentException(EXCEPTION_WRONG_LENGTH)
        }
    }
}