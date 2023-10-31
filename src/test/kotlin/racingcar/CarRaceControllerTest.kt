package racingcar

import camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest
import camp.nextstep.edu.missionutils.test.NsTest
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import racingcar.controllers.CarRaceController
import org.junit.jupiter.api.BeforeEach

class CarRaceControllerTest: NsTest() {

    @Test
    fun `inputCarNames에서 사용자가 중복된 이름을 넣은경우`() {
        assertSimpleTest {
            assertThrows<IllegalArgumentException> { runException("pobi,pobi", "3") }
        }
    }

    @Test
    fun `inputCarNames에서 사용자가 공백의 이름을 넣은경우`() {
        assertSimpleTest {
            assertThrows<IllegalArgumentException> { runException("", "3") }
        }
    }

    @Test
    fun `inputCarNames에서 사용자가 중간에 공백의 이름을 넣은경우`() {
        assertSimpleTest {
            assertThrows<IllegalArgumentException> { runException("pobi,,tobi", "3") }
        }
    }

    @Test
    fun `inputCarNames에서 사용자가 한명만 입력한경우`() {
        assertSimpleTest {
            assertThrows<IllegalArgumentException> { runException("pobi", "3") }
        }
    }

    @Test
    fun `inputCarNames에서 사용자가 5자 이상 입력한경우`() {
        assertSimpleTest {
            assertThrows<IllegalArgumentException> { runException("pobi,woniiii", "3") }
        }
    }

    @Test
    fun `inputNumberOfAttempts에서 사용자가 횟수를 음수를 넣은경우`() {
        assertSimpleTest {
            assertThrows<IllegalArgumentException> { runException("pobi,woni", "-1") }
        }
    }

    @Test
    fun `inputNumberOfAttempts에서 사용자가 횟수를 넣지 않은경우`() {
        assertSimpleTest {
            assertThrows<IllegalArgumentException> { runException("pobi,woni", " ") }
        }
    }

    @Test
    fun `inputNumberOfAttempts에서 사용자가 횟수에 숫자를 넣지 않은경우`() {
        assertSimpleTest {
            assertThrows<IllegalArgumentException> { runException("pobi,woni", "asdfasdf") }
        }
    }

    override fun runMain() {
        main()
    }
}