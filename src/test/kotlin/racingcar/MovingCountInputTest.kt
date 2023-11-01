package racingcar

import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.Test

class MovingCountInputTest {

    @Test
    fun `입력된 이동 횟수가 0 이하라면 예외가 발생한다`() {
        // given
        val countInput = "0"

        // then
        assertThatThrownBy {
            MoveCountInput.getMoveCount(countInput)
        }.isInstanceOf(IllegalArgumentException::class.java)
            .hasMessage("입력된 횟수가 0 이하입니다.")
    }
}
