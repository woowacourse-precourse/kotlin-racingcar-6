package racingcar.data

import camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest
import org.junit.jupiter.api.Test
import org.assertj.core.api.Assertions.assertThat

class CarFactoryTest {
    @Test
    fun `Car 생성`() {
        assertRandomNumberInRangeTest(
            {
                val names = listOf("prey", "paul", "holy")
                val count = 3
                val expected = listOf(
                    Car("prey", listOf(CarState.MOVING_FORWARD, CarState.STOP, CarState.MOVING_FORWARD)),
                    Car("paul", listOf(CarState.STOP, CarState.MOVING_FORWARD, CarState.STOP)),
                    Car("holy", listOf(CarState.STOP, CarState.STOP, CarState.MOVING_FORWARD))
                ).toTypedArray()
                val result = CarFactory.makeCarList(names, count)
                assertThat(result).containsExactly(*expected)
            },
            MOVING_FORWARD, STOP, MOVING_FORWARD,
            STOP, MOVING_FORWARD, STOP,
            STOP, STOP, MOVING_FORWARD
        )
    }

    companion object {
        private const val MOVING_FORWARD = 4
        private const val STOP = 3
    }
}