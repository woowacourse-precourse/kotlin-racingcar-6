package racingcar.util

import racingcar.util.Constants.EXCEPTION_WRONG_LENGTH
import racingcar.util.Constants.EXCEPTION_WRONG_NUMBER
import racingcar.util.Constants.EXCEPTION_DUPLICATE_CARS

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
}