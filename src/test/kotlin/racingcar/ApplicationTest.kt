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
            assertThrows<IllegalArgumentException>("5자 이하의 이름만 유효합니다.") {
                runException("pobi,javaji", "1")
            }
        }
        assertSimpleTest {
            assertThrows<IllegalArgumentException>("1자 이상의 이름만 유효합니다.") {
                run("pobi,,woni", "1")
            }
        }
        assertSimpleTest {
            assertThrows<IllegalArgumentException>("중복된 이름은 유효하지 않습니다.") {
                runException("pobi,woni,woni", "1")
            }
        }
    }

    @Test
    fun `시도 횟수에 대한 예외 처리`() {
        assertSimpleTest {
            assertThrows<IllegalArgumentException>("1 이상의 숫자만 유효합니다.") {
                runException("pobi,woni", "0")
            }
        }
        assertSimpleTest {
            assertThrows<IllegalArgumentException>("문자는 유효하지 않습니다.") {
                runException("pobi,woni", "a")
            }
        }
    }

    @Test
    fun `동일한 거리일 때 공동 우승 처리`() {
        assertRandomNumberInRangeTest(
            {
                run("pobi,woni", "5")
                assertThat(output()).contains("pobi : -----", "woni : -----", "최종 우승자 : pobi, woni")
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
