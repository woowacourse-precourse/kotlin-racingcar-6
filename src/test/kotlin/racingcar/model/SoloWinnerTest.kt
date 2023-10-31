package racingcar.model

import camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest
import camp.nextstep.edu.missionutils.test.NsTest
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import racingcar.main

class SoloWinnerTest : NsTest() {

    @Test
    fun `단독 레이싱 게임 시 우승자가 한 명일 때`() {
        assertRandomNumberInRangeTest(
            {
                run("son")
                assertThat(output()).contains("son : -", "최종 우승자 : son")
            },
            MOVING_FORWARD,
            STOP,
        )
    }

    @Test
    fun `단독 레이싱 게임 시 우승자가 없을 때`() {
        assertRandomNumberInRangeTest(
            {
                run("son")
                assertThat(output()).contains("son : ", NO_WINNER)
            },
            STOP,
            STOP,
        )
    }

    override fun runMain() {
        main()
    }

    companion object {
        private const val MOVING_FORWARD = 4
        private const val STOP = 3
        private const val NO_WINNER = "우승자가 없습니다."
    }
}
