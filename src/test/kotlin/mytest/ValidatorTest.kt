package mytest

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
    }
    @Test
    fun `자동차 이름에 숫자가 포함되어 있으면 예외처리`(){
        val carStringNameList: List<String> = listOf("pobi", "sik", "ju1n")
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
    fun `자동차 이름에 공백이 포함되어 있으면 예외처리`() {
        val carWhitespaceNameList: List<String> = listOf("po bi", "one", "jun")
        assertThrows<IllegalArgumentException>("이름에 공백이 포함되어 있습니다.") {
            if (carWhitespaceNameList.any { it.contains(" ") }) {
                throw IllegalArgumentException("이름에 공백이 포함되어 있습니다.")
            }
        }
    }
    @Test
    fun `자동차의 이름을 입력하지 않았다면 예외처리`() {
        val carBlankNameList: List<String> = listOf("")
        assertThrows<IllegalArgumentException>("이름을 입력해주세요.") {
            if (carBlankNameList.any { it.isBlank() }) {
                throw IllegalArgumentException("이름을 입력해주세요.")
            }
        }
    }

    @Test
    fun `시도횟수가 숫자가 아니면 예외처리`() {
        val tryCount = "1번"
        assertThrows<IllegalArgumentException>("유효한 숫자를 입력하세요.") {
            if (tryCount.toIntOrNull() == null) {
                throw IllegalArgumentException("유효한 숫자를 입력하세요.")
            }
        }
    }
}