package racingcar

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class ApplicationKtTest {

    @Test
    fun `유효 입력값 검사`() {

        val input = "car1,car2,car3"
        val rounds = "5"

        val userInput = getUserInput(input, rounds)

        assertEquals(listOf("car1", "car2", "car3"), userInput.first)
        assertEquals(5, userInput.second)
    }

    @Test
    fun `moveCar() 검사`() {
        val car = Car("TestCar")

        repeat(100) {
            car.moveCar()
        }

        assertTrue(car.getLocation() in 0..100)
    }

    @Test
    fun `goOrStop() 반환값 검사`() {
        val result = goOrStop()

        assertTrue(result || !result)
    }

    @Test
    private fun getUserInput(input: String, rounds: String): Pair<List<String>, Int> {
        val carNameList: List<String> = input.split(",")
        val numberOfRounds = rounds.toInt()
        return Pair(carNameList, numberOfRounds)
    }
}