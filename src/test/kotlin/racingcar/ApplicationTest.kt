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
    fun `자동차 이름이 공백인 경우 예외 처리`() {
        assertSimpleTest {
            assertThrows<IllegalArgumentException> { runException(" ", "1") }
        }
    }

    @Test
    fun `자동차 이름 갯수가 0개(공백)인 경우 예외 처리`() {
        assertSimpleTest {
            assertThrows<IllegalArgumentException> { runException("", "1") }
        }
    }

    @Test
    fun `자동차 이름 갯수가 11개인 경우 예외 처리`() {
        assertSimpleTest {
            assertThrows<IllegalArgumentException> {
                runException(
                    "alpha, beta, cobra, delta, email, fire, ghost, hype, ikea, july, kbo",
                    "1"
                )
            }
        }
    }

    @Test
    fun `이동 시도 횟수 0인 경우 예외 처리`() {
        assertSimpleTest {
            assertThrows<IllegalArgumentException> { runException("pobi,woni", "0") }
        }
    }

    @Test
    fun `이동 시도 횟수 11인 경우 예외 처리`() {
        assertSimpleTest {
            assertThrows<IllegalArgumentException> { runException("pobi,woni", "11") }
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
