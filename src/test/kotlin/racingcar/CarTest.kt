package racingcar

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test


class CarTest {

    @Test
    fun testCarMove() {
        val  car = Car("pobi")
        val car1 = Car("MyCar")
        car.move(5)
        assertEquals("-", car.distance)
        assertEquals(1, car.moveCount)
        assertEquals("pobi", car.carName)


        car1.move(2)
        assertEquals("", car1.distance)
        assertEquals(0, car1.moveCount)
        assertEquals("MyCar", car1.carName)
        Assertions.assertThat(car1.carName).isEqualTo("MyCar")
    }
}