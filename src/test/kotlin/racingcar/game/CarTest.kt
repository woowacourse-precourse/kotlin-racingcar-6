package racingcar.game

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

internal class CarTest {

    @Test
    fun `toString Test - distance가 0일때`() {
        // given
        val car = Car("bamin")
        val expectCarString = "bamin : "
        // when
        val carString = car.toString()
        // then
        assertEquals(expectCarString, carString)
    }

    @Test
    fun `toString 테스트 distance가 0이 아닐 경우`() {
        // given
        val car = Car("bamin")
        // when
        while (car.getDistance() > 0) {
            car.startEngine()
        }
        val carStringWithDistance = car.toString()
        // then
        val expectedString = "bamin : ${"-".repeat(car.getDistance())}"
        assertEquals(expectedString, carStringWithDistance)
    }

    @Test
    fun `getDistance 테스트`() {
        // given
        val car = Car("bamin")
        val expectCarDistance = 0
        // when
        val carDistance = car.getDistance()
        // then
        assertEquals(expectCarDistance, carDistance)
    }

    @Test
    fun `getName 테스트`() {
        // given
        val car = Car("bamin")
        val expectedName = "bamin"
        // when
        val carName = car.getName()
        // then
        assertEquals(expectedName, carName)
    }

    @Test
    fun `startEngine 테스트`() {
        // given
        val car = Car("bamin")
        val expectedResult = true
        // when
        val isCarEngineLevelInRange = car.startEngine() in 0..9
        // then
        assertEquals(expectedResult, isCarEngineLevelInRange)
    }
}