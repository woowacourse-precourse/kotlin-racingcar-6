package racingcar

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class CarTest {

    private val car = Car("Car1")

    @ParameterizedTest
    @ValueSource(ints = [4, 7, 9])
    fun `전진 조건이 4이상 일 때`(input: Int) {
        val whetherAdvance = car.findForwardCondition(input)

        assertEquals(ADVANCE_POSSIBLE, whetherAdvance)
    }

    @ParameterizedTest
    @ValueSource(ints = [0, 2])
    fun `전진 조건이 3이하 일 때`(input: Int) {
        val whetherAdvance = car.findForwardCondition(input)

        assertEquals(ADVANCE_IMPOSSIBLE, whetherAdvance)
    }

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
        private const val ADVANCE_POSSIBLE = true
        private const val ADVANCE_IMPOSSIBLE = false
    }

}