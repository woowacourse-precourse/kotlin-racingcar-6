package racingcar

import camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest
import org.assertj.core.api.AssertionsForClassTypes.assertThat
import org.junit.jupiter.api.Test
import racingcar.model.Car

class CarTest {
    @Test
    fun `자동차 전진 기능`() {
        val car = Car("sukk")
        assertRandomNumberInRangeTest(
            {
                car.move()
                car.move()
                car.move()
                car.move()
                assertThat(car.moveCount).isEqualTo(3)
            },
            MOVING_FORWARD, STOP, MOVING_FORWARD, MOVING_FORWARD
        )
    }

    companion object {
        private const val MOVING_FORWARD = 4
        private const val STOP = 3
    }
}