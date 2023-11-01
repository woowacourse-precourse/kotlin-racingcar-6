package racingcar

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test


class CarTest {

    @Test
    fun `차의 이름을 입력했을 때 잘 맞는지 테스트`() {
        val  car = Car("pobi")
        val car1 = Car("MyCar")

        assertEquals("pobi", car.carName)
        assertEquals("MyCar", car1.carName)
        Assertions.assertThat(car1.carName).isEqualTo("MyCar")
    }
    @Test
    fun `랜덤 숫자의 값에따라 전진했는지 여부 테스트`() {
        val  car = Car("pobi")
        val car1 = Car("MyCar")
        car.move(5)
        assertEquals("-", car.distance)

        car1.move(2)
        assertEquals("", car1.distance)
    }
    @Test
    fun `랜덤 숫자의 값에 따라 전진했는지 테스트 `() {
        val  car = Car("pobi")
        val car1 = Car("MyCar")
        car.move(5)
        assertEquals(1, car.moveCount)

        car1.move(2)
        assertEquals(0, car1.moveCount)

    }
}