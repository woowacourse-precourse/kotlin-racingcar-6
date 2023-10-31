package racingcar.model

import camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest
import camp.nextstep.edu.missionutils.test.NsTest
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import racingcar.main

class MultiWinnerTest : NsTest() {

    @Test
    fun `멀티 레이싱 게임 시 승자가 여러 명일 때`() {
        assertRandomNumberInRangeTest(
            {
                run("son,park,kim", "1")
                assertThat(output()).contains("son : -", "park : -", "kim : -", "최종 우승자 : son,park,kim")
            },
            MOVING_FORWARD,
            MOVING_FORWARD,
        )
    }

    @Test
    fun `멀티 레이싱 게임 시 승자가 없을 때`() {
        assertRandomNumberInRangeTest(
            {
                run("son,park,kim", "1")
                assertThat(output()).contains("son : ", "park : ", "kim : ", NO_WINNER)
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
        private const val NO_WINNER = "우승자가 없습니다."
        private const val STOP = 3
    }
}
