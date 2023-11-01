package racingcar

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertDoesNotThrow
import org.junit.jupiter.api.assertThrows

class CarTest {

    @Test
    fun `5자 이하의 이름에서 객체 생성`() {
        assertDoesNotThrow {
            val car = Car("john")
        }
    }

    @Test
    fun `5자 초과의 이름 예외처리`() {
        assertThrows<IllegalArgumentException> {
            val car = Car("michael")
        }
    }
}
