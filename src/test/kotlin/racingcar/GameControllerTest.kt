package racingcar

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest
import camp.nextstep.edu.missionutils.test.NsTest
import racingcar.controller.GameController

class GameControllerTest : NsTest() {
    @Test
    fun `게임 실행 기능 테스트`() {
        assertRandomNumberInRangeTest(
            {
                run("tiger,bear,cat", "3")
                assertThat(output()).contains(
                    "tiger : -",
                    "bear : ",
                    "cat : -",
                    "tiger : -",
                    "bear : -",
                    "cat : -",
                    "tiger : --",
                    "bear : --",
                    "cat : --",
                    "최종 우승자 : tiger, bear, cat"
                )
            },
            MOVING_FORWARD, STOP, MOVING_FORWARD, STOP, MOVING_FORWARD, STOP, MOVING_FORWARD, MOVING_FORWARD,
            MOVING_FORWARD
        )
    }

    override fun runMain() {
        val racingCarGame = GameController()
        racingCarGame.start()
    }

    companion object {
        private const val MOVING_FORWARD = 4
        private const val STOP = 3
    }
}