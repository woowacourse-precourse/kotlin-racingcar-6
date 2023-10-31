package racingcar

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class NameTest {
    private val exception = Exception()

    @Test
    fun `이름의 길이 예외 테스트`() {
        val input1 = "aaaaaa"
        val test1 = input1.split(",")

        assertThrows<IllegalArgumentException> { exception.nameValidation(test1) }
    }

    @Test
    fun `입력이 비어있을 경우`() {
        val input2 = ""
        val test2 = input2.split(",")

        assertThrows<IllegalArgumentException> { exception.nameValidation(test2) }
    }
}