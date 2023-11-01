package model

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import racingcar.model.Car

class CarTest {
    @Test
    fun `move()함수가 score를 1씩 증가시키는지 확인`() {
        val car = Car(name = "car1")

        val before = car.score
        car.move()
        val after = car.score

        assertEquals(before + 1, after)
    }
}
