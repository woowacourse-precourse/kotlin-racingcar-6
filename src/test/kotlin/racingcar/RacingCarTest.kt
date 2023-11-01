package racingcar

import camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest
import camp.nextstep.edu.missionutils.test.NsTest
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import racingcar.controller.RacingCarController
import racingcar.model.RacingCar

class RacingCarTest : NsTest() {
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

    override fun runMain() {
        main()
    }
}