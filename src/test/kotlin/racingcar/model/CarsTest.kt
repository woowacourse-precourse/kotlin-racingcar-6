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

}