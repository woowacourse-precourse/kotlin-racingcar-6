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

    companion object {
        const val INITIAL_POSITION = 0
        const val ADVANCE = 1
        const val STOP = 3
        const val MOVE = 4
    }

}