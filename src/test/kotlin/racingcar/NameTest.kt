package racingcar

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class NameTest {
    private val exception = Exception()

    @Test
    fun `이름의 길이 예외 테스트`() {
        val input1 = "aaaaaa"
        val input2 = ""

        val test1 = input1.split(",")
        val test2 = input2.split(",")

        assertThrows<IllegalArgumentException> { exception.nameValidation(test1) }
        assertThrows<IllegalArgumentException> { exception.nameValidation(test2) }
    }
}