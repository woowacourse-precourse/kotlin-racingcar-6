package lst1995kotlintest

import car.CarConfiguration.START_FLAG
import caroption.Engine
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class CarTest {
    @Test
    fun `Engine START_FLAG 입력 시 작동 검사`() {
        val input = START_FLAG
        val result = true
        assertThat(result).isEqualTo(Engine().start(input))
    }

    @Test
    fun `Engine START_FLAG 보다 작은 경계값 검사`() {
        val input = START_FLAG - 1
        val result = false
        assertThat(result).isEqualTo(Engine().start(input))
    }

    @Test
    fun `Engine START_FLAG 보다 큰 경계값 검사`() {
        val input = START_FLAG + 1
        val result = true
        assertThat(result).isEqualTo(Engine().start(input))
    }

}
