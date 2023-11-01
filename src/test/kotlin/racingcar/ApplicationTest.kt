package racingcar

import camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest
import camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest
import camp.nextstep.edu.missionutils.test.NsTest
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import racingcar.domain.car.Cars

class ApplicationTest : NsTest() {
    @AfterEach
    fun reset() {
        cars = Cars()
    }

    @Test
    fun `전진 정지`() {
        assertRandomNumberInRangeTest(
            {
                run("pobi,woni", "1")
                assertThat(output()).contains("pobi : -", "woni : ", "최종 우승자 : pobi")
            }, MOVING_FORWARD, STOP
        )
    }

    @Test
    fun `이름에 대한 예외 처리`() {
        assertSimpleTest {
            assertThrows<IllegalArgumentException> { runException("pobi,javaji", "1") }
        }
    }

    @Test
    fun `단독 우승시`() {
        assertRandomNumberInRangeTest(
            {
                run("pobi,woni,hodol", "2")
                assertThat(output()).contains("pobi : --", "woni : ", "hodol : ", "최종 우승자 : pobi")
            }, MOVING_FORWARD, STOP, STOP, MOVING_FORWARD, STOP, STOP
        )
    }

    @Test
    fun `공동 우승시`() {
        assertRandomNumberInRangeTest(
            {
                run("pobi,woni,joon", "1")
                assertThat(output()).contains(
                    "pobi : -", "woni : -", "joon : -", "최종 우승자 : pobi, woni, joon"
                )
            }, MOVING_FORWARD, MOVING_FORWARD, MOVING_FORWARD
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
