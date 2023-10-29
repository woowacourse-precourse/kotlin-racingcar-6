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
    fun `정지와 전진이 적절히 반영되어 우승자가 결정되는지 - 여러명일때`() {
        assertRandomNumberInRangeTest(
            {
                run("pobi,woni,hawai", "3")
                assertThat(output()).contains("pobi : -", "woni : ---", "hawai : ---", "최종 우승자 : woni, hawai")
            },
            MOVING_FORWARD, MOVING_FORWARD, MOVING_FORWARD,
            STOP, MOVING_FORWARD, MOVING_FORWARD,
            STOP, MOVING_FORWARD, MOVING_FORWARD
        )
    }

    @Test
    fun `정지와 전진이 적절히 반영되어 우승자가 결정되는지 - 다수의차량`() {
        assertRandomNumberInRangeTest(
            {
                run("pobi,woni,hawai,jae,young", "5")
                assertThat(output()).contains(
                    "pobi : ----",
                    "woni : ---",
                    "hawai : ---",
                    "jae : -----",
                    "young : -",
                    "최종 우승자 : jae"
                )
            },
            MOVING_FORWARD, MOVING_FORWARD, MOVING_FORWARD, MOVING_FORWARD, STOP,
            MOVING_FORWARD, MOVING_FORWARD, MOVING_FORWARD, MOVING_FORWARD, MOVING_FORWARD,
            STOP, STOP, STOP, MOVING_FORWARD, STOP,
            MOVING_FORWARD, STOP, MOVING_FORWARD, MOVING_FORWARD, STOP,
            MOVING_FORWARD, MOVING_FORWARD, STOP, MOVING_FORWARD, STOP,
        )
    }

    @Test
    fun `입력 순서대로 최종 우승자가 결정되는지`() {
        assertRandomNumberInRangeTest(
            {
                run("pobi,woni,hawai,jae,young", "5")
                assertThat(output()).contains(
                    "pobi : -----",
                    "woni : -----",
                    "hawai : -----",
                    "jae : -----",
                    "young : -----",
                    "최종 우승자 : pobi, woni, hawai, jae, young"
                )
            },
            MOVING_FORWARD, MOVING_FORWARD, MOVING_FORWARD, MOVING_FORWARD, MOVING_FORWARD,
            MOVING_FORWARD, MOVING_FORWARD, MOVING_FORWARD, MOVING_FORWARD, MOVING_FORWARD,
            MOVING_FORWARD, MOVING_FORWARD, MOVING_FORWARD, MOVING_FORWARD, MOVING_FORWARD,
            MOVING_FORWARD, MOVING_FORWARD, MOVING_FORWARD, MOVING_FORWARD, MOVING_FORWARD,
            MOVING_FORWARD, MOVING_FORWARD, MOVING_FORWARD, MOVING_FORWARD, MOVING_FORWARD,
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
}
