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
    fun `이름이 공백 예외 처리`() {
        assertSimpleTest {
            assertThrows<IllegalArgumentException> { runException("", "1") }
        }
    }
    @Test
    fun `반복 횟수 공백 예외 처리`() {
        assertSimpleTest {
            assertThrows<IllegalArgumentException> { runException("pobi,kim", " ") }
        }
    }
    @Test
    fun `반복 횟수가 음수일 경우 예외 처리`() {
        assertSimpleTest {
            assertThrows<IllegalArgumentException> { runException("pobi,woni,kim", "-3") }
        }
    }
    @Test
    fun `반복 횟수가 문자일 경우 예외 처리`() {
        assertSimpleTest {
            assertThrows<IllegalArgumentException> { runException("pobi,woni,kim", "a") }
        }
    }
    @Test
    fun `차 이름이 중복일 경우 예외 처리`() {
        assertSimpleTest {
            assertThrows<IllegalArgumentException> { runException("pobi,pobi,kim", "1") }
        }
    }
    @Test
    fun `이름 사이에 공백이 있을 경우 예외 처리`() {
        assertSimpleTest {
            assertThrows<IllegalArgumentException> { runException("pobi, pobi,kim", "1") }
        }
    }
    @Test
    fun `자동차 이름이 5글자 초과할 경우 예외 처리`() {
        assertSimpleTest {
            assertThrows<IllegalArgumentException> { runException("pobi,kim,leeyong", "1") }
        }
    }
    @Test
    fun `자동차 이름이 1글자 미만일 경우 예외 처리`() {
        assertSimpleTest {
            assertThrows<IllegalArgumentException> { runException("pobi,kim,,lee", "1") }
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