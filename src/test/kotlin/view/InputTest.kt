package view

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.Test
import racingcar.view.InputView
import java.io.ByteArrayInputStream

class InputTest {
    val inputView = InputView()

    @Test
    fun `이름이 5글자 이하인지 확인`() {
        val input = "car,apple,banana"
        System.setIn(ByteArrayInputStream(input.toByteArray()))

        val names = inputView.inputName()

        assertThat(names).containsExactly("car", "apple", "banana")
    }

    @Test
    fun `이름이 5글자를 초과하는 경우 에러 발생`() {
        // Given
        val input = "car,apple,bananaaa"
        System.setIn(ByteArrayInputStream(input.toByteArray()))

        // When & Then
        assertThatThrownBy { inputView.inputName() }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessage("이름은 5자리 이하만 입력이 가능합니다.")
    }

    @Test
    fun `입력받은 값이 숫자인지 확인`() {
        val input = "3"
        System.setIn(ByteArrayInputStream(input.toByteArray()))

        val count = inputView.inputCount()

        assertThat(count).isEqualTo(3)
    }

    @Test
    fun `입력받은 값이 숫자가 아닌 경우 에러 발생`() {
        val input = "abc"
        System.setIn(ByteArrayInputStream(input.toByteArray()))

        assertThatThrownBy { inputView.inputCount() }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessage("숫자만 입력이 가능합니다.")
    }

    @Test
    fun `입력받은 값이 0인 경우 에러 발생`() {
        val input = "0"
        System.setIn(ByteArrayInputStream(input.toByteArray()))

        assertThatThrownBy { inputView.inputCount() }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessage("0은 입력될 수 없습니다.")
    }
}
