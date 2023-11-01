package test

import camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test
import racingcar.model.Car
import racingcar.model.Name
import racingcar.model.Position

class CarTest {
    @Test
    fun `차 비교 테스트`() {
        val car1 = Car(name = Name("hello"), position = Position())
        val car2 = Car(name = Name("hello"), position = Position())
        assertRandomNumberInRangeTest(
            {
                car1.doRace()
                car2.doRace()
                Assertions.assertThat(car1 > car2)
                    .isEqualTo(false)
                car1.doRace()
                car2.doRace()
                Assertions.assertThat(car1 > car2)
                    .isEqualTo(false)
                Assertions.assertThat(car1.equals(car2))
                    .isEqualTo(true)
            },
            1, 5, 5, 1
        )
    }
}