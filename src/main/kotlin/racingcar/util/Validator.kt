package racingcar.util

import racingcar.util.Constants.MAX_NAME_LENGTH
import racingcar.util.Constants.MIN_COUNT_NUMBER
import java.lang.IllegalArgumentException

object Validator {
    fun validateLength(numberList: List<String>) {
        numberList.forEach {
            if (it.length > MAX_NAME_LENGTH) throw IllegalArgumentException(ExceptionMessage.INVALID_LENGTH.getMessage())
        }
    }

    fun validateUnique(numberList: List<String>) {
        val validation = numberList.toSet()
        if (validation.size != numberList.size) throw IllegalArgumentException(ExceptionMessage.INVALID_UNIQUE_NAME.getMessage())
    }

    fun validateNotNull(numberList: List<String>) {
        numberList.forEach {
            if (it.trim().isEmpty()) throw IllegalArgumentException(ExceptionMessage.INVALID_CAR_NAME.getMessage())
        }
    }

    fun validateInteger(number: String) {
        number.toIntOrNull() ?: throw IllegalArgumentException(ExceptionMessage.INVALID_INTEGER.getMessage())
    }

    fun validateRange(number: String) {
        val validation = number.toInt()
        if (validation !in MIN_COUNT_NUMBER..Int.MAX_VALUE) throw IllegalArgumentException(ExceptionMessage.INVALID_RANGE.getMessage())
    }
}