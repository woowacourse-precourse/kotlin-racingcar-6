package racingcar.domain

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class CarTest {

    @Test
    fun `move - 자동차는 랜덤값이 4 이상일 때 전진해야 한다`() {
        val car = Car("car1")
        car.move(4)
        assertEquals(1, car.getPosition())
        car.move(1)
        assertEquals(1, car.getPosition())
        car.move(3)
        assertEquals(1, car.getPosition())
        car.move(8)
        assertEquals(2, car.getPosition())
    }
}
