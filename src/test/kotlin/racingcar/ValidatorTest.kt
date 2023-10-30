package racingcar

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class ValidatorTest {

    @Test
    fun `자동차 이름이 5글자 이상 이거나 숫자가 포함되어 있다면 예외 처리`() {
        val carFiveNameList: List<String> = listOf("pobi", "sheepsik", "jun")
        assertThrows<IllegalArgumentException>("이름은 5글자 이하로 입력해주세요.") {
            if (carFiveNameList.any { it.length > 5 }) {
                throw throw IllegalArgumentException("이름은 5글자 이하로 입력해주세요.")
            }
        }
        val carStringNameList: List<String> = listOf("pobi", "sheep1sik", "ju1n")
        val regex = "\\d+".toRegex()
        assertThrows<IllegalArgumentException>("이름은 문자로만 입력하세요.") {
            for (numberCheck in carStringNameList){
                if (regex.containsMatchIn(numberCheck)) {
                    throw IllegalArgumentException("이름은 문자로 입력하세요.")
                }
            }
        }

    }

    @Test
    fun validateUserTryCount() {
    }
}