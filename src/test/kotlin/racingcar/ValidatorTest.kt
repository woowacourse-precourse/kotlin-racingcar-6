package racingcar

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import util.Validator

class ValidatorTest {
    @Test
    fun `예외 테스트) 입력 값이 없을 경우`() {
        assertThrows<IllegalArgumentException> {
            Validator().checkInputEmpty("")
        }
    }

    @Test
    fun `예외 테스트) 시도 횟수가 0번일 경우`() {
        assertThrows<IllegalArgumentException> {
            Validator().checkTryNum(0.toString())
        }
    }

    @Test
    fun `예외 테스트) 시도 횟수가 숫자가 아니거나 음수일 경우`() {
        assertThrows<IllegalArgumentException> {
            Validator().checkTryNum("-100")
        }
    }
}