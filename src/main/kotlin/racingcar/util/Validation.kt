package racingcar.util

import racingcar.util.Constants.EMPTY_ERROR
import racingcar.util.Constants.INPUT_NAME_ERROR
import racingcar.util.Constants.INPUT_NUM_ERROR

object Validation {

    fun validateName(cars: List<String>) {
        cars.forEach {
            if (it.length > 5) throw IllegalArgumentException(INPUT_NAME_ERROR)
        }
    }

    fun validateEmptyName(cars: List<String>) {
        cars.forEach {
            if (it.isEmpty()) throw IllegalArgumentException(EMPTY_ERROR)
        }
    }

    fun validateNum(num: String) {
        if (!num.all { it.isDigit() } || num.toInt() <= 0) {
            throw IllegalArgumentException(INPUT_NUM_ERROR)
        }
    }

    fun validateEmptyNum(num: String) {
        if (num.isEmpty()) throw IllegalArgumentException(EMPTY_ERROR)

    }

}