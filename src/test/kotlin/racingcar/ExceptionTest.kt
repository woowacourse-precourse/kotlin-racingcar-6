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
}