package racingcar.exception

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class CycleValidationTest {
    @Test
    fun `숫자를 입력 안했을 때 예외 발생`() {
        val input = "a"
        val length = input.length
        val result = input.matches(Regex("[0-9]{$length}"))
        assertThrows<IllegalArgumentException>("숫자만 입력해 주세요") {
            require(result) {
                "숫자만 입력해 주세요."
            }
        }
    }

    @Test
    fun `0을 입력했을 때 예외 발생`() {
        val input = "0"
        assertThrows<IllegalArgumentException>("이동 횟수는 1이상 입력해 주세요") {
            require(input.toInt() != 0) {
                "이동 횟수는 1이상 입력해 주세요"
            }
        }
    }

    @Test
    fun `값을 입력하지 않았을 때 예외 발생`() {
        val input = ""
        assertThrows<IllegalArgumentException> {
            require(input.isNotEmpty()) {
                "값을 입력해주세요."
            }
        }
    }
}