package racingcar

import camp.nextstep.edu.missionutils.test.Assertions
import camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest
import camp.nextstep.edu.missionutils.test.NsTest
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class RacingCarTest : NsTest() {
    @Test
    fun `시도 횟수 이상값 test`() {
        Assertions.assertSimpleTest {
            assertThrows<IllegalArgumentException> { runException("bon,jovi", "가") }
        }
        Assertions.assertSimpleTest {
            assertThrows<IllegalArgumentException> { runException("bon,jovi", "hello") }
        }
        Assertions.assertSimpleTest {
            assertThrows<IllegalArgumentException> { runException("bon,jovi", "-1") }
        }
        Assertions.assertSimpleTest {
            assertThrows<IllegalArgumentException> { runException("bon,jovi", "0") }
        }
    }

    @Test
    fun `공동 우승`() {
        assertRandomNumberInRangeTest(
            {
                run("bon,jovi", "3")
                assertThat(output()).contains("최종 우승자 : bon, jovi")
            },
            5
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