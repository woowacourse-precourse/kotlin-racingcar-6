package racingcar.domain

import camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class CarsTest {

    private lateinit var cars: Cars
    private val carNames = listOf("����", "����", "����")

    @BeforeEach
    fun setUp() {
        cars = Cars(DetermineMove())
        cars.createCar(carNames)
    }

    @Test
    fun `�ڵ��� ��ü�� ����� �����Ǿ����� Ȯ��`() {

        assertEquals(carNames.size, cars.carList.size)

        cars.carList.forEachIndexed { index, car ->
            assertEquals(car.name, carNames[index])
            assertEquals(car.advanceState, 0)
        }

    }

    @Test
    fun `����� ��� ��� �׽�Ʈ`() {
        assertRandomNumberInRangeTest(
            {
                cars.moveCars()
                assertThat(cars.getWinnerList())
                    .contains("����")

            }, MOVING_FORWARD, STOP, STOP, MOVING_FORWARD, MOVING_FORWARD, STOP

        )
    }

    companion object {
        private const val MOVING_FORWARD = 4
        private const val STOP = 3
    }

}