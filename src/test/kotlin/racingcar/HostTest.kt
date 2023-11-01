package racingcar

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class HostTest {

    private val host = Host()

    @Test
    fun `우승자 결정(우승자 1명)`() {
        val playersFinalPosition = listOf(5, 2, 3)
        val cars = listOf(
            Car("car1"),
            Car("car2"),
            Car("car3")
        )

        val winners = host.determineWinners(playersFinalPosition, cars)
        assertEquals("최종 우승자 : car1", winners)
    }

    @Test
    fun `우승자 결정(우승자 2명)`() {
        val playersFinalPosition = listOf(1, 2, 4, 4, 3)
        val cars = listOf(
            Car("car1"),
            Car("car2"),
            Car("car3"),
            Car("car4"),
            Car("car5")
        )

        val winners = host.determineWinners(playersFinalPosition, cars)
        assertEquals("최종 우승자 : car3, car4", winners)
    }

}