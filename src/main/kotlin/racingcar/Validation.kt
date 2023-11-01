package racingcar

import racingcar.constants.*
import kotlin.IllegalArgumentException

class Validation {

    fun isValidNumberOfCars(carNames: List<Car>) {
        if (carNames.size < MIN_NUMBER_CAR_NAMES) {
            throw IllegalArgumentException(ERROR_INPUT_CAR_NAMES_TWO_OR_MORE)
        }
    }

    fun checkContainsSpace(carNames: String) {
        if (carNames.contains(SPACE)) {
            throw IllegalArgumentException(ERROR_SEPARATE_CAR_NAMES_COMMA)
        }
    }

    fun checkCarNameDuplication(carNames: List<Car>) {
        val names = carNames.map { it.name }
        if (names.distinct().size != names.size) {
            throw IllegalArgumentException(ERROR_NAME_DUPLICATION)
        }
    }

    fun checkCarNameLength(carNames: List<Car>) {
        carNames.forEach {
            if (it.name.length > MAX_LENGTH_CAR_NAME) {
                throw IllegalArgumentException(ERROR_CAR_NAME_ONLY_FIVE_CHAR)
            }
        }
    }

    fun checkCarNameBlank(carNames: List<Car>) {
        if (carNames.any { it.name == BLANK }) {
            throw IllegalArgumentException(ERROR_CAR_NAME_CAN_NOT_BLANK)
        }
    }

    fun isValidCarName(carNames: String, cars: List<Car>) {
        checkContainsSpace(carNames)
        isValidNumberOfCars(cars)
        checkCarNameBlank(cars)
        checkCarNameDuplication(cars)
        checkCarNameLength(cars)
    }

    fun checkNumberBlank(numberOfAttempt: String): String {
        if (numberOfAttempt == BLANK) {
            throw IllegalArgumentException(ERROR_INPUT_VALUE)
        }
        return numberOfAttempt
    }

    fun checkNumberOrNot(numberOfAttempt: String): Int {
        return try {
            numberOfAttempt.toInt()
        } catch (e: Exception) {
            throw IllegalArgumentException(ERROR_INPUT_NUMBER_ONLY)
        }
    }

    fun checkNumberOfAttemptOneAndMore(numberOfAttemptToInt: Int) {
        if (numberOfAttemptToInt < MIN_NUMBER_OF_ATTEMPT) {
            throw IllegalArgumentException(ERROR_INPUT_ONE_OR_MORE)
        }
    }

    fun isValidNumberOfAttempt(numberOfAttempt: String): Int {
        checkNumberBlank(numberOfAttempt)
        val numberOfAttemptToInt = checkNumberOrNot(numberOfAttempt)
        checkNumberOfAttemptOneAndMore(numberOfAttemptToInt)

        return numberOfAttemptToInt
    }

}