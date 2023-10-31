package racingcar

import camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest
import camp.nextstep.edu.missionutils.test.NsTest
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class RaceTimeTest : NsTest() {
    @Test
    fun `시도 횟수가 0인 경우`() {
        assertSimpleTest {
            assertThrows<IllegalArgumentException> { runException("pobi,woni", "0") }
        }
    }

    @Test
    fun `시도 횟수가 음수인 경우`() {
        assertSimpleTest {
            assertThrows<IllegalArgumentException> { runException("pobi,woni", "-1") }
        }
    }

    @Test
    fun `시도 횟수가 숫자가 아닌 경우`() {
        assertSimpleTest {
            assertThrows<IllegalArgumentException> { runException("pobi,woni", "a") }
        }
    }

    public override fun runMain() {
        main()
    }

}
