package racingcar.view

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class InputTryTest {
    lateinit var inputTry: InputTry
    lateinit var input: String

    @BeforeEach
    fun setUp() {
        inputTry = InputTry()
    }

    @Test
    fun `숫자가 아닌 문자열을 입력하면 예외를 던진다`() {
        input = "abc"
        assertThrows<IllegalArgumentException>(
            "${Integer.MAX_VALUE} 이하의 자연수를 입력해주세요."
        ) {
            inputTry(input)
        }
    }

    @Test
    fun `0 이하의 숫자를 입력하면 예외를 던진다`() {
        input = "-1"
        assertThrows<IllegalArgumentException>(
            "${Integer.MAX_VALUE} 이하의 자연수를 입력해주세요."
        ) {
            inputTry(input)
        }
    }

    @Test
    fun `Int 형의 최대값보다 큰 숫자를 입력하면 예외를 던진다`() {
        input = "${Integer.MAX_VALUE + 1}"
        assertThrows<IllegalArgumentException>(
            "${Integer.MAX_VALUE} 이하의 자연수를 입력해주세요."
        ) {
            inputTry(input)
        }
    }

    @Test
    fun `Int 형 자연수를 문자열로 입력했을 시 해당 숫자를 Int 형으로 반환한다`() {
        input = "${Integer.MAX_VALUE}"
        val result = inputTry(input)
        assertThat(result).isEqualTo(Integer.MAX_VALUE)
    }

}
