package racingcar

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import racingcar.exception.UserInputException

class UserInputExceptionTest {
    @Test
    fun `자동차 이름이 6자 이상인 경우 예외처리`() {
        val userInput = listOf("tiger", "bear", "rabbit")
        val exception = assertThrows<IllegalArgumentException> { UserInputException.checkCarNameLength(userInput) }
        assertEquals("자동차 이름은 5자 이하여야 합니다.", exception.message)
    }

    @Test
    fun `입력값이 숫자가 아닌 경우 예외처리`() {
        val userInput = "a"
        val exception = assertThrows<IllegalArgumentException> { UserInputException.isNumber(userInput) }
        assertEquals("입력값은 숫자여야 합니다.", exception.message)
    }

}