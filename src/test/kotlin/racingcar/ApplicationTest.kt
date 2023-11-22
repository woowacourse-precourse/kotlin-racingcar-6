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
    fun `이름이 한 개만 들어오면`(){
        assertRandomNumberInRangeTest({
            run("woni","1")
            assertThat(output()).contains("최종 우승자 : woni")
        },
        MOVING_FORWARD
        )
    }
    @Test
    fun `우승자 여려명 테스트`() {
        assertRandomNumberInRangeTest(
            {
                run("woni,king", "1")
                assertThat(output()).contains("최종 우승자 : woni, king")
            },
            MOVING_FORWARD
        )
    }
        @Test
        fun `누적 확인 테스트`(){
            assertRandomNumberInRangeTest({
                run("woni,james","3")
                assertThat(output()).contains("최종 우승자 : james")
            },
                2, MOVING_FORWARD, MOVING_FORWARD, MOVING_FORWARD, MOVING_FORWARD, MOVING_FORWARD
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
