package racingcar.util

import java.lang.IllegalArgumentException

object Validator {
    fun validateLength(numberList: List<String>) {
        numberList.forEach {
            if (it.length > 5) throw IllegalArgumentException("자동차의 이름이 5보다 깁니다.")
        }
    }
}