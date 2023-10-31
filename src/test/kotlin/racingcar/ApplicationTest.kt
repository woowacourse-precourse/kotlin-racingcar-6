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
    fun `lapPrint 및 resultPrint 및 gameStart 함수 테스트, 회차 별 결과 출력과 복수의 우승자가 있을 시 처리`() {
        assertRandomNumberInRangeTest(
            {
                run("pobi,woni,jun", "5")
                assertThat(output()).contains(
                    "pobi : -", "woni : ", "jun : -",
                    "pobi : -----", "woni : ----", "jun : -----",
                    "최종 우승자 : pobi, jun")
            },
            MOVING_FORWARD, STOP, MOVING_FORWARD,
            MOVING_FORWARD, MOVING_FORWARD, MOVING_FORWARD,
            MOVING_FORWARD, MOVING_FORWARD, MOVING_FORWARD,
            MOVING_FORWARD, MOVING_FORWARD, MOVING_FORWARD,
            MOVING_FORWARD, MOVING_FORWARD, MOVING_FORWARD
        )
    }

    @Test
    fun `carInit 함수 테스트, 입력된 자동차 이름이 없을 경우`() {
        assertSimpleTest{
            assertThrows<IllegalArgumentException> { runException("", "1") }
        }
    }

    @Test
    fun `movingForward 함수 테스트, 경계값 검사`() {
        assertRandomNumberInRangeTest(
            {
                run("kim,Lee", "2")
                assertThat(output()).contains("kim : -", "Lee : -", "최종 우승자 : kim, Lee")
            },
            3,4,4,3
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
