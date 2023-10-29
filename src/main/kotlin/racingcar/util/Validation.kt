package racingcar.util

import racingcar.util.Constants.EXCEPTION_WRONG_LENGTH
import racingcar.util.Constants.EXCEPTION_WRONG_NUMBER
import racingcar.util.Constants.EXCEPTION_DUPLICATE_CARS
import racingcar.util.Constants.EXCEPTION_WRONG_BOUNDARY
import racingcar.util.Constants.MAX_ROUND_VALUE
import racingcar.util.Constants.MIN_ROUND_VALUE

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

    fun validateNumberOfCars(cars: MutableList<String>) {
        if (cars.size < 2) {
            throw IllegalArgumentException(EXCEPTION_WRONG_NUMBER)
        }
    }

    fun validateDuplicateOfCars(cars: MutableList<String>) {
        if (cars.toSet().size != cars.size) {
            throw IllegalArgumentException(EXCEPTION_DUPLICATE_CARS)
        }
    }

    fun validateRound(num: String): Int {
        if (num < MIN_ROUND_VALUE.toString() || num > MAX_ROUND_VALUE.toString()) {
            throw IllegalArgumentException(EXCEPTION_WRONG_BOUNDARY)
        }
        return num.toInt()
    }
}