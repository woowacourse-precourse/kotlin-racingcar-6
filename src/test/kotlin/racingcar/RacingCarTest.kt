package racingcar

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test
import racingcar.model.RacingCar
import racingcar.model.RacingCars

class RacingCarTest {

    @Test
    fun `자동차에는 이름을 부여할 수 있다`() {
        val racingCar = RacingCar("테스트", "")
        Assertions.assertThat(racingCar.name).isEqualTo("테스트")
    }

    @Test
    fun `자동차를 몇 번 이동할 것인지 입력할 수 있다`() {
        val racingCars = RacingCars(mutableListOf(), 5)
        Assertions.assertThat(racingCars.tryCnt).isEqualTo(5)
    }
}
