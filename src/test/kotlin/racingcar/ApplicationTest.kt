package racingcar

import camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest
import camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest
import camp.nextstep.edu.missionutils.test.NsTest
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

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
    fun `단독 우승`() {
        assertRandomNumberInRangeTest(
                {
                    run("pobi,woni", "2")
                    assertThat(output()).contains("pobi : ", "woni : --", "최종 우승자 : woni")
                },
                STOP, MOVING_FORWARD, STOP, MOVING_FORWARD
        )
    }

    @Test
    fun `혼자 경기한 경우`() {
        assertRandomNumberInRangeTest(
                {
                    run("pobi", "2")
                    assertThat(output()).contains("pobi : ", "최종 우승자 : pobi")
                },
                STOP, STOP
        )
    }

    @Test
    fun `1, 3번째가 우승한 경우`() {
        assertRandomNumberInRangeTest(
                {
                    run("pobi,woni,rilla", "3")
                    assertThat(output()).contains("pobi : --", "woni : ", "rilla : --", "최종 우승자 : pobi, rilla")
                },
                MOVING_FORWARD, STOP, MOVING_FORWARD, STOP, STOP, MOVING_FORWARD, MOVING_FORWARD, STOP, STOP
        )
    }

    @Test
    fun `공동 우승`() {
        assertRandomNumberInRangeTest(
                {
                    run("pobi,woni", "1")
                    assertThat(output()).contains("pobi : -", "woni : -", "최종 우승자 : pobi, woni")
                },
                MOVING_FORWARD, MOVING_FORWARD
        )
    }

    @Test
    fun `모두 전진 실패`() {
        assertRandomNumberInRangeTest(
                {
                    run("pobi,woni", "3")
                    assertThat(output()).contains("pobi : ", "woni : ", "최종 우승자 : pobi, woni")
                },
                STOP, STOP, STOP, STOP, STOP, STOP
        )
    }

    @Test
    fun `모두 전진 성공`() {
        assertRandomNumberInRangeTest(
                {
                    run("pobi,woni", "2")
                    assertThat(output()).contains("pobi : --", "woni : --", "최종 우승자 : pobi, woni")
                },
                MOVING_FORWARD, MOVING_FORWARD, MOVING_FORWARD, MOVING_FORWARD
        )
    }

    @Test
    fun `전진 스탑 스탑 전진`() {
        assertRandomNumberInRangeTest(
                {
                    run("pobi,woni", "2")
                    assertThat(output()).contains("pobi : -", "woni : -", "최종 우승자 : pobi, woni")
                },
                MOVING_FORWARD, STOP, STOP, MOVING_FORWARD
        )
    }

    public override fun runMain() {
        main()
    }

    companion object {
        private const val MOVING_FORWARD = 4
        private const val STOP = 3
    }
}
