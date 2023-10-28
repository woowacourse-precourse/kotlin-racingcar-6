package racingcar.game

import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.assertDoesNotThrow
import org.junit.jupiter.api.assertThrows
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
        val result = game.inputCarName(carNames)
        assertEquals(listOf("Car1", "Car2", "Car3"), result)
    }

    @ParameterizedTest
    @ValueSource(strings = ["Car1,Car23", "pobi,woni,jun", " pob i , j u n "])
    fun `자동차 이름이 1자 이상 5자인 경우`(carNames: String) {
        assertDoesNotThrow {
            game.inputCarName(carNames)
        }
    }

    @ParameterizedTest
    @ValueSource(strings = ["Car12,Car345", " p o b i , jun", ",jun", " ,jun"])
    fun `자동차 이름이 1자 미만 또는 5자 초과인 경우`(carNames: String) {
        assertThrows<IllegalArgumentException> {
            game.inputCarName(carNames)
        }
    }
}