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
        assertRandomNumberInRangeTest({
            run("pobi,woni", "1")
            assertThat(output()).contains("pobi : -", "woni : ", "최종 우승자 : pobi")
            assertThat(output()).contains("pobi : -", "woni : ", "최종 우승자 : woni")
        }, MOVING_FORWARD, STOP)
    }


    @Test
    fun `이름에 대한 예외 처리`() {
        //자동차 입력값이 5글자 초과
        assertSimpleTest {
            assertThrows<IllegalArgumentException> { runException("pobi,javaji", "1") }
        }

        //자동차 입력값이 없을 경우
        assertSimpleTest {
            assertThrows<IllegalArgumentException> { runException("", "1") }
        }
        assertSimpleTest {
            assertThrows<IllegalArgumentException> { runException(" ", "1") }
        }

        //자동차 입력값이 중복인 경우
        assertSimpleTest {
            assertThrows<IllegalArgumentException> { runException("eddy,eddy", "1") }
        }


        //playTime 값이 제대로 입력이 안된 경우
        assertSimpleTest {
            assertThrows<IllegalArgumentException> { runException("pobi,javaji", "") }
        }

        assertSimpleTest {
            assertThrows<IllegalArgumentException> { runException("pobi,javaji", " ") }
        }

        //playTime 값이 정수가 아닌 값이 입력이 된 경우
        assertSimpleTest {
            assertThrows<IllegalArgumentException> { runException("pobi,javaji", "행복") }
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
