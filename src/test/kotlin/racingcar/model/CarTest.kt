package racingcar.model

import camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class CarTest {
    companion object {
        private const val MOVING_FORWARD = 4
        private const val STOP = 3
    }

    @Test
    fun `Car 이름은 공백이면 안됩니다`() {
        assertThrows<IllegalArgumentException> {
            Car("")
        }
    }

    @Test
    fun `Car 이름은 5를 넘으면 안됩니다`() {
        assertThrows<IllegalArgumentException> {
            Car("123456")
        }
    }

    @Test
    fun `Car 의 처음 위치는 0 입니다`() {
        assertThat(Car("test").pos).isEqualTo(0)
    }

    @Test
    fun `Car move 테스트`() {
        val car = Car("move")

        assertRandomNumberInRangeTest(
            {
                assertThat(car.pos).isEqualTo(0)
                car.move()
                assertThat(car.pos).isEqualTo(1)
                car.move()
                assertThat(car.pos).isEqualTo(1)
                car.move()
                assertThat(car.pos).isEqualTo(2)
            },
            MOVING_FORWARD, STOP, MOVING_FORWARD
        )
    }
}