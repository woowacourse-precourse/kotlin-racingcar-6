package racingcar


import camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest
import camp.nextstep.edu.missionutils.test.NsTest
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class CarRaceTest : NsTest() {

    @Test
    fun `자동차 이름 입력에 대한 예외 처리`() {
        assertSimpleTest {
            assertThrows<IllegalArgumentException> { runException("abcdef,123456") }
        }
    }

    @Test
    fun `시도 횟수 입력에 대한 예외 처리`() {
        assertSimpleTest {
            assertThrows<IllegalArgumentException> { runException("park,sung,hoon", "abc") }
        }
    }

    override fun runMain() {
        main()
    }
}