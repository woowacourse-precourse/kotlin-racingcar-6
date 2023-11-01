package racingcar.utils

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import racingcar.model.RacingCar

class StringExtTest {

    @Test
    fun `이름은 공백이 포함되지 않고 길이가 1~5에 속해야 한다`() {
        val nameWithBlank = "po bi"
        val nameWithWrongLength = "abcdef"
        assertThrows<IllegalArgumentException> { nameWithBlank.toRacingCar() }
        assertThrows<IllegalArgumentException> { nameWithWrongLength.toRacingCar() }
    }

    @Test
    fun `toRacingCar 메소드는 해당 이름과 location이 0인 RacingCar 객체를 반환한다`() {
        val name = "pobi"
        assertThat(name.toRacingCar()).isEqualTo(
            RacingCar("pobi", 0)
        )
    }
}