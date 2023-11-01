package racingcar

import camp.nextstep.edu.missionutils.Randoms
import camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest
import camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest
import camp.nextstep.edu.missionutils.test.NsTest
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import racingcar.model.GameReferee
import racingcar.view.InputView

class ApplicationTest : NsTest() {
    @Test
    fun `전진 정지`() {
        assertRandomNumberInRangeTest(
            {
                run("pobi,woni", "1")
                assertThat(output()).contains("pobi : -", "woni : ", "최종 우승자 : pobi")
            },
            MOVING_FORWARD, STOP
        )
    }

    @Test
    fun `이름에 대한 예외 처리`() {
        assertSimpleTest {
            assertThrows<IllegalArgumentException> { runException("pobi,javaji", "1") }
        }
    }

    @Test
    fun `공동 우승자`() {
        assertRandomNumberInRangeTest(
            {
                run("pobi,woni,jun", "1")
                assertThat(output()).contains("pobi : -", "woni : -", "jun : ", "최종 우승자 : pobi, woni")
            },
            MOVING_FORWARD, MOVING_FORWARD, STOP
        )
    }

    @Test
    fun `난수가 0이상 3이하, 자동차 전진 진위 여부`() {
        val gameReferee = GameReferee()
        val flag = gameReferee.validatePossibleForward(Randoms.pickNumberInRange(0, 3))
        assertEquals(false, flag)
    }

    @Test
    fun `난수가 4이상 9이하, 자동차 전진 진위 여부`() {
        val gameReferee = GameReferee()
        val flag = gameReferee.validatePossibleForward(Randoms.pickNumberInRange(4, 9))
        assertEquals(true, flag)
    }

    @Test
    fun `시도 횟수가 정수가 아닐때 예외 처리`() {
        assertSimpleTest {
            val exception = assertThrows<IllegalArgumentException> { runException("pobi,woni", "c") }
            assertEquals(exception.message, InputView.ERROR_ATTEMPT_COUNT)
        }
    }
    public override fun runMain() {
        main()
    }

    companion object {
        private const val MOVING_FORWARD = 4
        private const val STOP = 3
    }
}
