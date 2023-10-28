package racingcar

import camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest
import camp.nextstep.edu.missionutils.test.NsTest
import org.junit.jupiter.api.Test
import racingcar.raceModel.Car
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.assertThrows

class RaceTest : NsTest() {

    @Test
    fun `자동차의 이름은 쉼표로 구분한다`() {
        val carNames = "car1,car2,car3"
        val cars = carNames.split(",").map { Car(it) }
        assertThat(cars).hasSize(3)
        assertThat(cars[0].name).isEqualTo("car1")
        assertThat(cars[1].name).isEqualTo("car2")
        assertThat(cars[2].name).isEqualTo("car3")
    }

    @Test
    fun `자동차의 이름은 5자 이하여야 한다`() {
        val carName = "자동차의 이름"
        assertThrows<IllegalArgumentException> {
            Car(carName)
        }
    }

    @Test
    fun `자동차는 값이 4 이상일때 전진한다`() {
        assertRandomNumberInRangeTest({
            run("car1,car2", "1")
            assertThat(output()).contains("car1 : -", "car2 : ", "최종 우승자 : car1")
        }, MOVING_FORWARD, STOP)
    }

    @Test
    fun `우승자가 두 명 이상일 경우 쉼표를 통해 구분한다`() {
        assertRandomNumberInRangeTest({
            run("car1,car2", "1")
            assertThat(output()).contains("car1 : -", "car2 : -", "최종 우승자 : car1, car2")
        }, MOVING_FORWARD, MOVING_FORWARD)
    }


    companion object {
        private const val MOVING_FORWARD = 4
        private const val STOP = 3
    }

    override fun runMain() {
        main()
    }
}