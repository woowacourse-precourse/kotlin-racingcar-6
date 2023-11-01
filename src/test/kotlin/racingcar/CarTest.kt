package racingcar

import camp.nextstep.edu.missionutils.test.Assertions
import org.junit.jupiter.api.Assertions.assertEquals
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

    @Test
    fun `전진 테스트`() {
        val car = Car("a")
        Assertions.assertRandomNumberInRangeTest(
            {
                car.goForwardOrStop()
                assertEquals(car.position, 1)
            },
            4,
        )
    }

    @Test
    fun `정지 테스트`() {
        val car = Car("a")
        Assertions.assertRandomNumberInRangeTest(
            {
                car.goForwardOrStop()
                assertEquals(car.position, 0)
            },
            3,
        )
    }
}
