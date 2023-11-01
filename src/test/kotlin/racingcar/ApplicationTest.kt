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
    fun `자동차 이름 및 시도 횟수 입력 테스트`() {
        assertSimpleTest{
            run("kjin,jhan", "3")
            assertThat(output().contains(""))
        }
    }

    @Test
    fun `단독 우승자`() {
        assertRandomNumberInRangeTest(
            {
                run("pobi,woni", "1")
                assertThat(output()).contains("최종 우승자 : pobi")
            },
            MOVING_FORWARD
        )
    }

    @Test
    fun `공동 우승자`() {
        assertRandomNumberInRangeTest(
            {
                run("pobi,woni", "1")
                assertThat(output()).contains("최종 우승자 : pobi, woni")
            },
            MOVING_FORWARD, MOVING_FORWARD
        )
    }

    @Test
    fun `이름 입력 시 알파벳, 숫자, 쉼표만 입력 확인`() {
        assertRandomNumberInRangeTest(
            {
                run("pobi,woni3", "1")
                assertThat(output()).contains("최종 우승자 : pobi")
            },
            MOVING_FORWARD
        )
    }

    @Test
    fun `이름의 길이가 1~5자가 아닌 예외 처리`() {
        assertSimpleTest {
            assertThrows<IllegalArgumentException> { runException("abcdefg", "1") }
        }
    }

    @Test
    fun `이름 입력값 중복 예외 처리`() {
        assertSimpleTest {
            assertThrows<IllegalArgumentException> { runException("pobi,pobi", "1") }
        }
    }

    @Test
    fun `이름 입력값 빈 문자열 예외 처리`() {
        assertSimpleTest {
            assertThrows<IllegalArgumentException> { runException("", "1") }
        }
    }

    @Test
    fun `이름 입력값 공백 예외 처리`() {
        assertSimpleTest {
            assertThrows<IllegalArgumentException> { runException("pobi, woni", "1") }
        }
    }

    @Test
    fun `시도 횟수가 숫자가 아닌 경우 예외 처리`() {
        assertSimpleTest {
            assertThrows<IllegalArgumentException> { runException("pobi,woni", "abc") }
        }
    }

    @Test
    fun `시도 횟수가 음수인 경우 예외 처리`() {
        assertSimpleTest {
            assertThrows<IllegalArgumentException> { runException("pobi,woni", "-1") }
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
