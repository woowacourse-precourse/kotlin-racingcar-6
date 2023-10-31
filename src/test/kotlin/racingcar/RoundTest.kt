package racingcar

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class RoundTest {
    private val exception = Exception()

    @Test
    fun `라운드 입력이 정수값이 이닐 경우`() {
        val input1 = "aaa"

        assertThrows<IllegalArgumentException> { exception.roundsValidation(input1) }
    }

    @Test
    fun `라운드 입력이 비어 있을 경우`() {
        val input2 = ""

        assertThrows<IllegalArgumentException> { exception.roundsValidation(input2) }
    }

    @Test
    fun `라운드 입력이 음수인 경우`() {
        val input3 = "-1"

        assertThrows<IllegalArgumentException> { exception.roundsValidation(input3) }
    }
}