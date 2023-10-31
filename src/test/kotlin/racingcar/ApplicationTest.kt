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
    fun `전진 전진`() {
        assertRandomNumberInRangeTest(
            {
                run("pobi,woni", "2")
                assertThat(output()).contains(
                    "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)",
                    "시도할 횟수는 몇 회인가요?",
                    "실행 결과",
                    "pobi : -",
                    "woni : -",
                    "pobi : --",
                    "woni : --",
                    "최종 우승자 : pobi, woni"
                )
            },
            MOVING_FORWARD, MOVING_FORWARD
        )
    }

    @Test
    fun `이름의 길이는 1글자 이상 5글자 이하`() {
        assertSimpleTest {
            assertThrows<IllegalArgumentException>("문자열의 길이가 1글자 이상 5글자 이하여야 합니다") { runException("pobi, ", "1") }
        }
    }

    @Test
    fun `실행 횟수에 대한 예외 처리`() {
        assertSimpleTest {
            assertThrows<IllegalArgumentException>("문자열은 숫자여야 합니다") { runException("pobi,woni", "a") }
        }
        assertSimpleTest {
            assertThrows<IllegalArgumentException>("0은 유효하지 않습니다") { runException("pobi,woni", "0") }
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
