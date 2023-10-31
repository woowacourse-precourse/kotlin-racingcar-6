package racingcar

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class CarTest {
    private val car = Car("aa", 0)

    @Test
    fun `자동차가 움직이는 경우`() {
        val num = 8
        car.moving(num)
        assertThat(car.position).isEqualTo(1)
    }

    @Test
    fun `이동한 위치값 가져오기`() {
        val move = MOVE
        // 3번 이동
        car.moving(move)
        car.moving(move)
        car.moving(move)
        val status = car.getStatus()
        assertThat(status).isEqualTo("aa : ---")
    }

    companion object {
        const val MOVE = 5
    }
}