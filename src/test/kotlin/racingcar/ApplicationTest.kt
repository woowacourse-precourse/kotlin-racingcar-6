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
    fun `pobi 우승`() {
        assertRandomNumberInRangeTest(
            {
                run("pobi,woni,booze", "2")
                assertThat(output()).contains("pobi : --", "woni : -", "booze : ", "최종 우승자 : pobi")
            },
            MOVING_FORWARD, STOP, STOP, MOVING_FORWARD, MOVING_FORWARD, STOP
        )
    }

    @Test
    fun `공동 우승(전진)`() {
        assertRandomNumberInRangeTest(
            {
                run("pobi,woni,booze", "2")
                assertThat(output()).contains("pobi : --", "woni : --", "booze : --", "최종 우승자 : pobi, woni, booze")
            },
            MOVING_FORWARD, MOVING_FORWARD, MOVING_FORWARD,, MOVING_FORWARD, MOVING_FORWARD, MOVING_FORWARD
        )

    }
    @Test
    fun `공동 우승(정지)`() {
        assertRandomNumberInRangeTest(
            {
                run("pobi,woni,booze", "2")
                assertThat(output()).contains("pobi : ", "woni : ", "booze : ", "최종 우승자 : pobi, woni, booze")
            },
            STOP, STOP, STOP, STOP, STOP, STOP
        )

    }

    @Test
    fun `이름에 대한 예외 처리`() {
        assertSimpleTest {
            assertThrows<IllegalArgumentException> { runException("pobi,boozea", "1") }
        }
    }

    @Test
    fun `이름에 대한 예외 처리(공백)`() {
        assertRandomNumberInRangeTest(
            {
                run(" pobi  , woni ", "1")
                assertThat(output()).contains("pobi : -", "woni : ", "최종 우승자 : pobi")
            },
            MOVING_FORWARD, STOP
        )
    }

    @Test
    fun `1명의 사용자에 대한 예외 처리`() {
        assertSimpleTest {
            assertThrows<IllegalArgumentException> { runException("pobi") }
        }
    }

    @Test
    fun `올바르지 않은 시행 횟수에 대한 예외 처리`() {
        assertSimpleTest {
            assertThrows<IllegalArgumentException> { runException("pobi,booze", "0") }
        }
    }

    @Test
    fun `올바르지 않은 시행 횟수에 대한 예외 처리(음수)`() {
        assertSimpleTest {
            assertThrows<IllegalArgumentException> { runException("pobi,booze", "-1") }
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
