package racingcar.game

import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.assertEquals

class GameTest {

    private lateinit var game: Game

    @BeforeEach
    fun setUp() {
        game = Game()
    }

    @Test
    fun `입력값을 올바르게 split`() {
        val input = "Car1,Car2,Car3"

        val carList = game.inputCarName(input)

        assertEquals(listOf("Car1", "Car2", "Car3"), carList)
    }
}