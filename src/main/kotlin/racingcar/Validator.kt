package racingcar

import java.lang.IllegalArgumentException

object Validator {
    fun validateNameLength(carList: List<String>) {
        carList.forEach {
            if (it.length > 5) throw IllegalArgumentException("차 이름의 길이가 5보다 큽니다.")
        }
    }

    fun validateNull(carList: List<String>) {
        carList.forEach {
            if (it.trim().isEmpty()) throw IllegalArgumentException("차 이름에 널값이 존재합니다.")
        }
    }

    fun validateDuplicate(carList: List<String>) {
        val validation = carList.toSet()
        if (validation.size != carList.size) throw IllegalArgumentException("중복된 차 이름이 존재합니다.")
    }

    fun validateNumber(count: String) {
        count.toIntOrNull() ?: throw IllegalArgumentException("사용자의 입력이 숫자가 아닙니다.")
    }
}