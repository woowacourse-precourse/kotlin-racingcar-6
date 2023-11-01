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

    @Test
    fun `입력된 자동차 개수가 1개 이하면 예외가 발생한다`() {
        // given
        val racingCarName: List<Car> = listOf(Car("abcde"))

        // then
        assertThatThrownBy {
            RacingCarInput.validate(racingCarName)
        }.isInstanceOf(IllegalArgumentException::class.java)
            .hasMessage("입력된 자동차의 개수가 1개 이하입니다.")
    }

    @Test
    fun `중복된 자동차 이름이 입력되면 예외가 발생한다`() {
        // given
        val racingCarName: List<Car> = listOf(
            Car("abcde"),
            Car("abcde")
        )

        // then
        assertThatThrownBy {
            RacingCarInput.validate(racingCarName)
        }.isInstanceOf(IllegalArgumentException::class.java)
            .hasMessage("중복되는 자동차 이름이 있습니다.")
    }
}
