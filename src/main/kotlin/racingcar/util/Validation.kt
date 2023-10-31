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
        if (name.length !in 1..5) {
            throw IllegalArgumentException(EXCEPTION_WRONG_LENGTH)
        }
        return name
    }

    fun validateNumberOfCars(cars: List<String>) {
        if (cars.size < 2) {
            throw IllegalArgumentException(EXCEPTION_WRONG_NUMBER)
        }
    }

    fun validateDuplicateOfCars(cars: List<String>) {
        if (cars.toSet().size != cars.size) {
            throw IllegalArgumentException(EXCEPTION_DUPLICATE_CARS)
        }
    }

    fun validateRound(num: String): Int {
        if (num.toLong() !in MIN_ROUND_VALUE..MAX_ROUND_VALUE) {
            throw IllegalArgumentException(EXCEPTION_WRONG_BOUNDARY)
        }
        return num.toInt()
    }
}