package racingcar

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class RoundTest {
    private val exception = Exception()

    @Test
    fun `라운드 예외 테스트`() {
        val input1 = "aaa"
        val input2 = ""
        val input3 = "-1"

        assertThrows<IllegalArgumentException> { exception.roundsValidation(input1) }
        assertThrows<IllegalArgumentException> { exception.roundsValidation(input2) }
        assertThrows<IllegalArgumentException> { exception.roundsValidation(input3) }
    }
}