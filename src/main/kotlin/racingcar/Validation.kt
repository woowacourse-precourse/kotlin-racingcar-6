package racingcar

import kotlin.IllegalArgumentException

class Validation {

    fun isValidNumberOfCars(carsNameList: List<Car>) {
        if (carsNameList.size < MIN_NUMBER_CAR_NAMES) {
            throw IllegalArgumentException(ERROR_INPUT_CAR_NAMES_TWO_OR_MORE)
        }
    }

    fun checkContainsSpace(carsName: String) {
        if (carsName.contains(SPACE)) {
            throw IllegalArgumentException(ERROR_SEPARATE_CAR_NAMES_COMMA)
        }
    }

    fun checkCarNameDuplication(carsNameList: List<Car>) {
        val names = carsNameList.map { it.name }
        if (names.distinct().size != names.size) {
            throw IllegalArgumentException(ERROR_NAME_DUPLICATION)
        }
    }

    fun checkCarNameLength(carsNameList: List<Car>) {
        carsNameList.forEach {
            if (it.name.length > MAX_LENGTH_CAR_NAME) {
                throw IllegalArgumentException(ERROR_CAR_NAME_ONLY_FIVE_CHAR)
            }
        }
    }

    fun checkCarNameBlank(carsNameList: List<Car>) {
        if (carsNameList.any { it.name == BLANK }) {
            throw IllegalArgumentException(ERROR_CAR_NAME_CAN_NOT_BLANK)
        }
    }

    fun isValidCarName(carsName: String, carList: List<Car>) {
        checkContainsSpace(carsName)
        isValidNumberOfCars(carList)
        checkCarNameBlank(carList)
        checkCarNameDuplication(carList)
        checkCarNameLength(carList)
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