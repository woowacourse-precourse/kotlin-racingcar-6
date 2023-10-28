package racingcar.game

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

internal class CarTest {

    @Test
    fun testToString() {
        // given
        val car = Car("bamin")
        val expectCarString = "bamin : "
        // when
        val carString = car.toString()
        // then
        assertEquals(expectCarString, carString)
    }

    @Test
    fun getDistance() {
        // given
        val car = Car("bamin")
        val expectCarDistance = 0
        // when
        val carDistance = car.getDistance()
        // then
        assertEquals(expectCarDistance, carDistance)
    }

    @Test
    fun getName() {
        // given
        val car = Car("bamin")
        val expectedName = "bamin"
        // when
        val carName = car.getName()
        // then
        assertEquals(expectedName, carName)
    }
}