package racingcar.model

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertDoesNotThrow
import org.junit.jupiter.api.assertThrows
import racingcar.model.Cars.Companion.DUPLICATED_CARS

class CarsTest {

    @Test
    fun `자동차들에 중복된 이름이 있다면 에외를 던진다`() {
        val exception = assertThrows<IllegalArgumentException> {
            Cars.withNames("pobi", "pobi")
        }

        assertThat(exception.message).isEqualTo(DUPLICATED_CARS)
    }

    @Test
    fun `정상적인 자동차들은 통과한다`() {
        assertDoesNotThrow {
            Cars.withNames("pobi", "woni", "jun")
        }
    }

    @Test
    fun `자동차들 중 우승자를 알아낸다`() {
        val cars = Cars(
            listOf(
                Car("pobi", 0),
                Car("woni", 1),
                Car("jun", 3),
            )
        )

        val winners = cars.getWinners()
        assertThat(winners).isEqualTo(listOf(Car("jun", 3)))
    }

}