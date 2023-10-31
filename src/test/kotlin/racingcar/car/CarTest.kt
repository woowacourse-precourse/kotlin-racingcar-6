package racingcar.car

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*
import racingcar.car.Car
import racingcar.car.MoveStrategy

class CarTest {

    @Test
    fun `car가 움직일 경우 결과 확인`() {
        //given
        val car = Car("pobi", object : MoveStrategy {
            override fun isMovable(): Boolean {
                return true
            }
        })

        //when
        repeat(4) { car.moveForward() }

        //then
        assertEquals("pobi : ----", "$car")
    }

    @Test
    fun `car가 움직이지 않을 경우 결과 확인`() {
        //given
        val car = Car("pobi", object : MoveStrategy {
            override fun isMovable(): Boolean {
                return false
            }
        })

        //when
        repeat(4) { car.moveForward() }

        //then
        assertEquals("pobi : ", "$car")

    }
}