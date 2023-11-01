package racingcar.model

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class RacingCarTest {

    @Test
    fun `RacingCar의 toString()는 자동차의 이름과 위치를 string값으로 반환한다`() {
        val name = "pobi"
        val position = 5
        val racingCar = RacingCar(carName = name, location = position)
        assertThat(racingCar.toString()).isEqualTo("pobi : -----")
    }

    @Test
    fun `RacingCar의 compareTo()함수는 두 객체를 location을 기준으로 비교하며 내림차순인지 확인한다`() {
        val car1 = RacingCar("pobi", 4)
        val car2 = RacingCar("woni", 5)
        assertThat(car1.compareTo(car2)).isEqualTo(1)
        assertThat(car2.compareTo(car1)).isEqualTo(-1)
    }
}