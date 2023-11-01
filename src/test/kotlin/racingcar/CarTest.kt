package racingcar

import camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class CarTest {

    @Test
    fun `이름이 공백인 예외 케이스`() {
        assertSimpleTest {
            assertThrows<IllegalArgumentException> { Car("") }
        }
    }

    @Test
    fun `이름이 숫자인 예외케이스`() {
        assertSimpleTest {
            assertThrows<IllegalArgumentException> { Car("1") }
        }
    }

    @Test
    fun `이름이 5글자를 넘는 것이 포함된 예외 케이스`() {
        assertSimpleTest {
            assertThrows<IllegalArgumentException> { Car("inseong") }
        }
    }

}