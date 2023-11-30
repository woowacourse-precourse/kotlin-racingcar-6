package racingcar.model

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class MoveStrategyTest {

    private lateinit var moveStrategy: MoveStrategy

    @ParameterizedTest
    @ValueSource(booleans = [true, false])
    fun `자동차의 전진 조건을 검사한다`(canMove: Boolean) {
        // given
        val car = Car("pobi", 0)
        moveStrategy = object : MoveStrategy {
            override fun canMoveForward(car: Car) = canMove
        }

        // when
        moveStrategy.canMoveForward(car)

        // then
        assertThat(moveStrategy.canMoveForward(car)).isEqualTo(canMove)
    }

}