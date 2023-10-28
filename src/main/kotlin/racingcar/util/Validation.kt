package racingcar.util

import racingcar.util.Constants.EXCEPTION_WRONG_LENGTH
import racingcar.util.Constants.EXCEPTION_WRONG_NUMBER

object Validation {

    fun validateLength(str: String): String {
        val name = str.trim()
        println(name.length)
        if (name.length in 1..5) {
            return name
        } else {
            throw IllegalArgumentException(EXCEPTION_WRONG_LENGTH)
        }
    }

    fun validateNumberOfList(list: MutableList<String>) {
        if (list.size < 2) {
            throw IllegalArgumentException(EXCEPTION_WRONG_NUMBER)
        }
    }
}