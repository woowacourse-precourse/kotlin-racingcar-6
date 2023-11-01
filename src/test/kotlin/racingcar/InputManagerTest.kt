package racingcar

import camp.nextstep.edu.missionutils.test.Assertions
import camp.nextstep.edu.missionutils.test.NsTest
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class InputManagerTest: NsTest() {
    @Test
    fun `이름에 대한 예외 처리`() {
        Assertions.assertSimpleTest {
            assertThrows<IllegalArgumentException> { runException("pobi,java, minsu", "1") }
        }
    }

    @Test
    fun `실행 횟수가 음수 일 경우 예외 처리`() {
        Assertions.assertSimpleTest {
            assertThrows<IllegalArgumentException> { runException("pobi,sam,rupi", "-1") }
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