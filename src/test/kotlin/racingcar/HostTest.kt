package racingcar

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class HostTest {

    private val host = Host()

    @Test
    fun `라운드별 경주 상황`() {
        val cars = listOf(
            Car("폴리"),
            Car("로이"),
            Car("앰버")
        )
        val randomNumbers = listOf(5, 2, 7)
        var index = 0
        val positions = host.printCurrentRaceSituation(cars) { randomNumbers[index++] }

        assertEquals(ADVANCE, positions[POLI])
        assertEquals(INITIAL_POSITION, positions[ROY])
        assertEquals(ADVANCE, positions[AMBER])
    }

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

    companion object {
        private const val INITIAL_POSITION = 0
        private const val ADVANCE = 1
        private const val POLI = 0
        private const val ROY = 1
        private const val AMBER = 2
    }

}