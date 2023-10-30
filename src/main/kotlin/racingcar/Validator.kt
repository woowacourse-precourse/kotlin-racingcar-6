package racingcar

import java.lang.IllegalArgumentException

object Validator {
    private const val MAX_LENGTH = 5
    private const val INVALID_LENGTH = "자동차 이름의 길이가 5보다 큽니다."
    private const val INVALID_NAME = "자동차 이름에 널값이 존재합니다."
    private const val INVALID_UNIQUE = "중복된 자동차 이름이 존재합니다."
    private const val INVALID_NUMBER = "사용자의 입력이 숫자가 아닙니다."
    private const val INVALID_RANGE = "실행 횟수가 1 이상이어야 합니다."

    fun validateNameLength(carList: List<String>) {
        carList.forEach {
            if (it.length > MAX_LENGTH) throw IllegalArgumentException(INVALID_LENGTH)
        }
    }

    fun validateNull(carList: List<String>) {
        carList.forEach {
            if (it.trim().isEmpty()) throw IllegalArgumentException(INVALID_NAME)
        }
    }

    fun validateDuplicate(carList: List<String>) {
        val validation = carList.toSet()
        if (validation.size != carList.size) throw IllegalArgumentException(INVALID_UNIQUE)
    }

    fun validateNumber(count: String) {
        count.toIntOrNull() ?: throw IllegalArgumentException(INVALID_NUMBER)
    }

    fun validateRange(count: String) {
        if (count == "0") throw IllegalArgumentException(INVALID_RANGE)
    }
}