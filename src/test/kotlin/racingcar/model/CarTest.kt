package racingcar.model

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import racingcar.util.Constants.MOVE_FORWARD
import racingcar.util.Constants.MOVE_STOP

class CarTest {

    private lateinit var car: Car
    private val moveStep = MoveStep

    @BeforeEach
    fun setUp() {
        car = Car("jun", 0)
    }

    @Test
    fun `Car의 move()을 호출하면 position은 0 또는 1입니다`() {
        car.move(moveStep)
        assertThat(car.position).isIn(MOVE_STOP, MOVE_FORWARD)
    }
}