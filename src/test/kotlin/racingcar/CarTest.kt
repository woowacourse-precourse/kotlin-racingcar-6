package racingcar

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class CarTest {

    private val car = Car("Car1")

    @Test
    fun `차량이 3 이하의 숫자를 받으면 전진하지 않음`() {
        val currentPosition = car.move(STOP)
        assertEquals(INITIAL_POSITION, currentPosition)
    }

    @Test
    fun `차량이 4 이상의 숫자를 받으면 전진`() {
        val currentPosition = car.move(MOVE)
        assertEquals(INITIAL_POSITION + ADVANCE, currentPosition)
    }

    @Test
    fun `차량이 4 이상의 숫자를 연속해서 받았을 때`() {
        car.move(MOVE)
        val finalPosition = car.move(MOVE)
        assertEquals(INITIAL_POSITION + ADVANCE * 2, finalPosition)
    }

    companion object {
        private const val INITIAL_POSITION = 0
        private const val ADVANCE = 1
        private const val STOP = 3
        private const val MOVE = 4
    }

}