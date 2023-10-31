package myTest

import org.junit.jupiter.api.Test
import org.assertj.core.api.Assertions.assertThatThrownBy
import racingcar.userInput
import java.io.ByteArrayInputStream

class runInputTest {
    @Test
    private fun runInputTest(input: String) {
        val originalIn = System.`in`

        try {
            System.setIn(ByteArrayInputStream(input.toByteArray()))
            assertThatThrownBy { userInput() }
                .isInstanceOf(IllegalArgumentException::class.java)
        } finally {
            System.setIn(originalIn)
        }
    }

    @Test
    fun `5글자가_넘는_이름_입력`() {
        runInputTest("test,testtttt,tes")
    }

    @Test
    fun `빈 문자열을 입력한 경우`() {
        runInputTest("")
    }

    @Test
    fun `횟수에 숫자를 입력하지 않고 다른 수를 입력하는 경우`() {
        runInputTest("tes,test,te,tt\nf")
    }

    @Test
    fun `횟수에 아무것도 입력하지 않는 경우`() {
        runInputTest("tes,test,te,tt\n")
    }

}