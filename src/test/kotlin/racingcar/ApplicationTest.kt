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
    fun `이름에 대한 예외 처리 - 중복된 이름을 입력한 경우`() {
        assertSimpleTest {
            assertThrows<IllegalArgumentException> { runException("pobi,pobi", "1") }
        }
    }

    @Test
    fun `이름에 대한 예외 처리 - 공백을 입력한 경우`() {
        assertSimpleTest {
            assertThrows<IllegalArgumentException> { runException("pobi,,woni", "1") }
        }
    }

    @Test
    fun `이동 횟수에 대한 예외 처리 - 공백을 입력한 경우`() {
        assertSimpleTest {
            assertThrows<IllegalArgumentException> { runException("pobi,woni,jun", " ") }
        }
    }

    @Test
    fun `이동 횟수에 대한 예외 처리 - 숫자와 문자열을 함께 입력한 경우`() {
        assertSimpleTest {
            assertThrows<IllegalArgumentException> { runException("pobi,woni,jun", "1.0") }
        }
    }

    @Test
    fun `이동 횟수에 대한 예외 처리 - 문자열을 입력한 경우`() {
        assertSimpleTest {
            assertThrows<IllegalArgumentException> { runException("pobi,woni,jun", "test") }
        }
    }

    @Test
    fun `우승자가 복수일 경우 출력 값이 올바른지 확인`() {
        assertRandomNumberInRangeTest(
            {
                run("pobi,woni", "1")
                assertThat(output()).contains("pobi : -", "woni : -", "최종 우승자 : pobi, woni")
            },
            MOVING_FORWARD, MOVING_FORWARD
        )
    }

    @Test
    fun `입력한 이동 횟수만큼 위치가 증가하는지 확인 1`() {
        assertRandomNumberInRangeTest(
            {
                run("pobi", "4")
                assertThat(output()).contains("pobi : -", "pobi : --", "pobi : ---", "pobi : ----")
            },
            MOVING_FORWARD, MOVING_FORWARD, MOVING_FORWARD, MOVING_FORWARD
        )
    }

    @Test
    fun `입력한 이동 횟수만큼 위치가 증가하는지 확인 2`() {
        assertRandomNumberInRangeTest(
            {
                run("pobi", "4")
                assertThat(output()).contains("pobi : -", "pobi : --")
            },
            MOVING_FORWARD, STOP, MOVING_FORWARD, STOP
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
