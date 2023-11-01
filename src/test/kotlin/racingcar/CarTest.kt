package racingcar

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class CarTest {
    private lateinit var car: Car

    @BeforeEach
    fun setUp() {
        car = Car("test")
    }

    @Test
    fun `CAN_MOVE_FORWARD_NUMBER 미만인 조건에서 전진하지 않아야 함`() {
        val prevForwardCount = car.forwardCount
        car.tryMoveForward(CAN_MOVE_FORWARD_NUMBER - 1)

        val result = prevForwardCount == car.forwardCount

        assertThat(result).isTrue()
    }

    @Test
    fun `CAN_MOVE_FORWARD_NUMBER 조건에서 전진해야 함`() {
        val prevForwardCount = car.forwardCount
        car.tryMoveForward(CAN_MOVE_FORWARD_NUMBER)

        val result = prevForwardCount + 1 == car.forwardCount

        assertThat(result).isTrue()
    }

    @Test
    fun `CAN_MOVE_FORWARD_NUMBER 초과인 조건에서 전진해야 함`() {
        val prevForwardCount = car.forwardCount
        car.tryMoveForward(CAN_MOVE_FORWARD_NUMBER + 1)

        val result = prevForwardCount + 1 == car.forwardCount

        assertThat(result).isTrue()
    }
}