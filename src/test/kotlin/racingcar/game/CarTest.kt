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
}