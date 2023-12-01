package racingcar.model

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

class MoveStrategyTest {

    private lateinit var moveStrategy: MoveStrategy

    @ParameterizedTest
    @CsvSource(
        "0, true, 1",
        "0, false, 0",
        "11, true, 12",
        "11, false, 11"
    )
    fun `자동차의 전진 조건에 따라 전진한다`(firstPosition: Int, canMove: Boolean, expectedPosition: Int) {
        // given
        val car = Car("pobi", firstPosition)
        moveStrategy = object : MoveStrategy {
            override fun moveForward(car: Car) {
                if (canMove) {
                    car.moveForward()
                }
            }
        }

        // when
        moveStrategy.moveForward(car)

        // then
        assertThat(car.position).isEqualTo(expectedPosition)
    }
}