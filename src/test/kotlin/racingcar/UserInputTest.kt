package racingcar

import camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest
import camp.nextstep.edu.missionutils.test.NsTest
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertDoesNotThrow
import org.junit.jupiter.api.assertThrows

class UserInputTest : NsTest() {

    @Test
    fun `성공`() {
        assertSimpleTest {
            assertDoesNotThrow { run("pobi,woni", "3") }
        }
    }

    @Test
    fun `이름 입력 시 null 또는 공백이 포함되지 않아야 한다`() {
        assertSimpleTest {
            assertThrows<IllegalArgumentException> { runException(null) }
        }
        assertSimpleTest {
            assertThrows<IllegalArgumentException> { runException(" ") }
        }

        assertSimpleTest {
            assertThrows<IllegalArgumentException> { runException("pobi,wo ni") }
        }
        assertSimpleTest {
            assertThrows<IllegalArgumentException> { runException("pobi,woni ") }
        }
    }

    @Test
    fun `자동차는 중복되지 않는 최소 2대 이상이어야 한다`() {
        assertSimpleTest {
            assertThrows<IllegalArgumentException> { runException("pobi") }
        }
        assertSimpleTest {
            assertThrows<IllegalArgumentException> { runException("pobi,pobi") }
        }
    }

    @Test
    fun `시도 횟수는 모든 문자가 숫자이어야 한다`() {
        assertSimpleTest {
            assertThrows<IllegalArgumentException> { runException("pobi,woni", "1a") }
        }
    }

    @Test
    fun `시도 횟수는 1 이상의 숫자이어야 한다`() {
        assertSimpleTest {
            assertThrows<IllegalArgumentException> { runException("pobi,woni", "0") }
        }
        assertSimpleTest {
            assertThrows<IllegalArgumentException> { runException("pobi,woni", "-123") }
        }
    }

    override fun runMain() {
        main()
    }
}