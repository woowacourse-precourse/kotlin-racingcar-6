package racingcar

import camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest
import camp.nextstep.edu.missionutils.test.NsTest
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import racingcar.controller.RacingCarController
import racingcar.model.RacingCar

class RacingCarTest : NsTest() {

    val racingCarController = RacingCarController()

    @Test
    fun `전진을 하는지 테스트`() {
        assertRandomNumberInRangeTest(
            {
                val racingCar = RacingCar("lee", 0)
                racingCar.addRacingCarDistance()
                assertThat(racingCar).isEqualTo(RacingCar("lee", 1))
            },
            5
        )
    }

    @Test
    fun `전진을 못하는 경우 테스트`() {
        assertRandomNumberInRangeTest(
            {
                val racingCar = RacingCar("lee", 0)
                racingCar.addRacingCarDistance()
                assertThat(racingCar).isEqualTo(RacingCar("lee", 0))
            },
            2
        )
    }

    @Test
    fun `우승자가 1명일 때`() {
        val data = listOf(RacingCar("pobi", 1), RacingCar("woni", 2), RacingCar("jun", 3))
        val result = racingCarController.findMaxDistanceRacingCar(data)
        assertThat(result).isEqualTo(listOf("jun"))
    }

    @Test
    fun `우승자가 2명일 때`() {
        val data = listOf(RacingCar("pobi", 1), RacingCar("woni", 3), RacingCar("jun", 3))
        val result = racingCarController.findMaxDistanceRacingCar(data)
        assertThat(result).isEqualTo(listOf("woni", "jun"))
    }

    override fun runMain() {
        main()
    }
}