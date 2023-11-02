package racingcar.util

import java.lang.IllegalArgumentException

object Validator {
    fun validateLength(numberList: List<String>) {
        numberList.forEach {
            if (it.length > 5) throw IllegalArgumentException("자동차의 이름이 5보다 깁니다.")
        }
    }

    fun validateUnique(numberList: List<String>) {
        val validation = numberList.toSet()
        if (validation.size != numberList.size) throw IllegalArgumentException("중복된 자동차의 이름이 존재합니다.")
    }
}