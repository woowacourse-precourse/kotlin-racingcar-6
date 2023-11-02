package racingcar.util

import java.lang.IllegalArgumentException

object Validator {
    fun validateLength(numberList: List<String>) {
        numberList.forEach {
            if (it.length > 5) throw IllegalArgumentException(ExceptionMessage.INVALID_LENGTH.getMessage())
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
        if (validation !in 1..Int.MAX_VALUE) throw IllegalArgumentException(ExceptionMessage.INVALID_RANGE.getMessage())
    }
}