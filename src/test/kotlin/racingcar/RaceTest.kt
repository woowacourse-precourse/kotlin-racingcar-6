/* Race 클래스가 open 클래스 일때 가능한 ovrride*/
/*
package racingcar

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import racingcar.domain.Race

class RaceTest {
    @Test
    fun `racing test when all cars should move`() {
        val race = object : Race() {
            override fun goOrStop(): Int {
                return 1
            }
        }

        val cars = mapOf("car1" to 0, "car2" to 0, "car3" to 0)
        val result = race.racing(cars)

        assertEquals(mapOf("car1" to 1, "car2" to 1, "car3" to 1), result)
    }

    @Test
    fun `racing test when no cars should move`() {
        val race = object : Race() {
            override fun goOrStop(): Int {
                return 0 // 항상 멈춤
            }
        }

        val cars = mapOf("car1" to 0, "car2" to 0, "car3" to 0)
        val result = race.racing(cars)

        assertEquals(mapOf("car1" to 0, "car2" to 0, "car3" to 0), result)
    }
}
 */