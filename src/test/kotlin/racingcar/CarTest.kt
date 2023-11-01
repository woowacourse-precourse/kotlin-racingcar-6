package racingcar

import camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import racingcar.domain.Car
import racingcar.domain.Validator
class CarTest {

    @Test
    fun `이름 중복 예외`() {
        assertSimpleTest {
            assertThrows<IllegalArgumentException> { Validator("mark,mark", 3)}
        }
    }

    @Test
    fun `이름 5자 초과 예외`() {
        assertSimpleTest{
            assertThrows<IllegalArgumentException> { Car("chominji") }
        }
    }
}