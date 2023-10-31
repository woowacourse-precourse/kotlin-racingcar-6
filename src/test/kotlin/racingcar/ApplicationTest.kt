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
            }, MOVING_FORWARD, STOP
        )
    }

    @Test
    fun `이름에 대한 예외 처리`() {
        assertSimpleTest {
            assertThrows<IllegalArgumentException> { runException("pobi,javaji", "1") }
        }
    }

    @Test
    fun `공동 우승자의 경우`() {
        assertRandomNumberInRangeTest(
            {
                run("pobi,woni", "1")
                assertThat(output()).contains("pobi : -", "woni : -", "최종 우승자 : pobi, woni")
            }, MOVING_FORWARD, MOVING_FORWARD
        )
    }

    @Test
    fun `모두 전진을 못한 경우의 경우 공동 우승`() {
        assertRandomNumberInRangeTest(
            {
                run("pobi,woni", "1")
                assertThat(output()).contains("pobi : ", "woni : ", "최종 우승자 : pobi, woni")
            }, STOP, STOP
        )
    }

    @Test
    fun `입력한 시도 횟수만큼 반복`() {
        assertRandomNumberInRangeTest(
            {
                run("chae", "3")
                assertThat(output()).contains("chae : -", "chae : --", "chae : ---", "최종 우승자 : chae")
            }, MOVING_FORWARD, MOVING_FORWARD, MOVING_FORWARD
        )
    }

    @Test
    fun `이름 입력값이 빈 문자열인 경우 예외 처리`() {
        assertSimpleTest {
            assertThrows<IllegalArgumentException> { runException("", "") }
        }
    }

    @Test
    fun `이름 입력값이 공백의 경우 예외 처리`() {
        assertSimpleTest {
            assertThrows<IllegalArgumentException> { runException(" ", "1") }
        }
    }


    @Test
    fun `이름에 대한 중복 예외 처리`() {
        val invalidNames = "car1,car2,car1"
        val count = "3"

        assertSimpleTest {
            assertThrows<IllegalArgumentException> { runException(invalidNames, count) }
        }
    }

    @Test
    fun `시도 횟수가 숫자가 아닌 경우 예외 처리`() {
        val validNames = "car1,car2,car3"
        val count = "a"

        assertSimpleTest {
            assertThrows<IllegalArgumentException> { runException(validNames, count) }
        }
    }

    @Test
    fun `시도 횟수가 음수인 경우 예외 처리`() {
        val validNames = "car1,car2,car3"
        val count = "-1"

        assertSimpleTest {
            assertThrows<IllegalArgumentException> { runException(validNames, count) }
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
