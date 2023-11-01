package racingcar

import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.Test

class RacingCarInputTest {

    @Test
    fun `입력된 자동차 이름이 5자 초과이면 예외가 발생한다`() {
        // given
        val racingCarName: List<Car> = listOf(
            Car("abcdef"), Car("abcde")
        )

        //then
        assertThatThrownBy {
            RacingCarInput.validate(racingCarName)
        }.isInstanceOf(IllegalArgumentException::class.java)
            .hasMessage("입력된 자동차 이름이 5자 초과입니다.")
    }
}
