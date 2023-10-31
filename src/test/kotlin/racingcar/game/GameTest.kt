package racingcar.game

import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class GameTest {

    private lateinit var game: Game

    @BeforeEach
    fun setUp() {
        game = Game()
    }

    @ParameterizedTest
    @ValueSource(strings = ["Car1,Car2,Car3"])
    fun `입력값을 올바르게 split`(carNames: String) {
        val result = game.splitCarName(carNames)
        assertEquals(listOf("Car1", "Car2", "Car3"), result)
    }
}