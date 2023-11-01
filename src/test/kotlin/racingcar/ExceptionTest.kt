package racingcar

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import racingcar.controller.RacingcarController

class ExceptionTest {
    private val racingcarController = RacingcarController()

    @Test
    fun `자동차 이름이 5자 이하 인지 검사`() {
        val input = "rangeTest"
        assertThrows<IllegalArgumentException> {
            racingcarController.checkCarNameLength(input)
        }
    }

    @Test
    fun `입력한 시도할 횟수가 올바른지 검사`() {
        val input = "a"
        assertThrows<IllegalArgumentException> {
            racingcarController.checkTryNumber(input)
        }
    }
}