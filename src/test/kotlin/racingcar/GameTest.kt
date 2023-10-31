import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import racingcar.Car
import racingcar.Game

class GameTest {

    @Test
    fun `runGame with valid input`() {
        val testCar1 = Car("abc")
        val testCar2 = Car("def")
        val game = Game(listOf(testCar1, testCar2), 10)
        game.runGame()

        val car1Position = testCar1.position
        val car2Position = testCar2.position

        Assertions.assertTrue(car1Position >= 0 && car2Position >= 0)
    }
}