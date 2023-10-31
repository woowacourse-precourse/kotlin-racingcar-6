package racingcar

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import java.io.ByteArrayInputStream

class MainTest {
    @Test
    fun `main function with invalid car input`() {
        val input = "ace, abcedf"
        System.setIn(ByteArrayInputStream(input.toByteArray()))

        val exception = assertThrows<IllegalArgumentException> { main() }
        Assertions.assertEquals("자동차 이름은 5자 이하이며, 쉼표로 구분되어야 합니다.", exception.message)
    }

    @Test
    fun `main function with invalid number of moves`() {
        val input = "a"
        System.setIn(ByteArrayInputStream(input.toByteArray()))

        val exception = assertThrows<IllegalArgumentException> { main() }
        Assertions.assertEquals("숫자를 입력해야 합니다.", exception.message)
    }
}