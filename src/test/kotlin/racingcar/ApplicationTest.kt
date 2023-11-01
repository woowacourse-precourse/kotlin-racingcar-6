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
    fun `동명의 자동차 처리`() {
        assertSimpleTest {
            assertThrows<IllegalArgumentException> { runException("pobi,pobi,woni", "1") }
        }
    }
    @Test
    fun `이동 횟수가 0 이상의 정수가 아닌 경우 처리`() {
        assertSimpleTest {
            assertThrows<IllegalArgumentException> { runException("pobi,woni,mlnv", "-5") }
            assertThrows<IllegalArgumentException> { runException("pobi,woni,mlnv", "0.3") }
            assertThrows<IllegalArgumentException> { runException("pobi,woni,mlnv", "A") }
            assertThrows<IllegalArgumentException> { runException("pobi,woni,mlnv", "!!") }
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
