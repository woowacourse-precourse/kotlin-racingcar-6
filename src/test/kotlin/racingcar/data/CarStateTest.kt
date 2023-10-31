package racingcar.data

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class CarStateTest {
    @Test
    fun `STOP 이 제대로 나오는지`() {
        val input = 0
        val result = CarState.toCarState(input)
        assertThat(result).isEqualTo(CarState.STOP)
    }

    @Test
    fun `MOVE 경계 테스트`() {
        val input = 4
        val result = CarState.toCarState(input)
        assertThat(result).isEqualTo(CarState.MOVING_FORWARD)
    }

    @Test
    fun `MOVE 최대값 테스트`() {
        val input = 9
        val result = CarState.toCarState(input)
        assertThat(result).isEqualTo(CarState.MOVING_FORWARD)
    }
}