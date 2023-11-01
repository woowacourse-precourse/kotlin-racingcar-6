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

    public override fun runMain() {
        main()
    }

    companion object {
        private const val MOVING_FORWARD = 4
        private const val STOP = 3
    }


    @Test
    fun `자동차 이름이 5자를 초과할 시 예외 발생`() {
        assertThrows<IllegalArgumentException>("자동차 이름은 5자 이하만 가능") {
            validationCarName(listOf("abc", "abcdef"))
        }
    }

    @Test
    fun `시도할 횟수가 숫자가 아닐 때 예외 발생`() {
        assertThrows<IllegalArgumentException>("숫자만 입력 가능") {
            validationNumberAttempts("12a")
            validationNumberAttempts("abc")
        }
    }

    @Test
    fun `자동차 이름이 중복된 경우 예외 발생`() {
        assertThrows<IllegalArgumentException>("중복된 이름은 사용할 수 없습니다.") {
            validationCarName(listOf("abc", "abc", "abcde"))
        }
    }

    @Test
    fun `시도 횟수가 0인 경우 예외 발생`() {
        assertThrows<IllegalArgumentException>("0번 시도할 수는 없습니다.") {
            validationNumberAttempts("0")
        }
    }
}
