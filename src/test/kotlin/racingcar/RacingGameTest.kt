package racingcar

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class RacingGameTest {

    private val game = RacingGame()

    @Test
    fun `경주 결과(최종 위치 확인)`() {
        val numberOfAttempts = 4
        val cars = listOf(
            Car("폴리"),
            Car("로이"),
            Car("앰버")
        )
        var invocationCount = 0
        val mockRace: (List<Car>) -> List<Int> = {
            invocationCount++
            listOf(
                POLI_FINAL_POSITION,
                ROY_FINAL_POSITION,
                AMBER_FINAL_POSITION
            )
        }

        val result = game.printRaceResult(numberOfAttempts, cars, mockRace)

        assertEquals(numberOfAttempts, invocationCount)
        assertEquals(POLI_FINAL_POSITION, result[POLI])
        assertEquals(ROY_FINAL_POSITION, result[ROY])
        assertEquals(AMBER_FINAL_POSITION, result[AMBER])
    }

    companion object {
        private const val POLI = 0
        private const val ROY = 1
        private const val AMBER = 2
        private const val POLI_FINAL_POSITION = 1
        private const val ROY_FINAL_POSITION = 4
        private const val AMBER_FINAL_POSITION = 2
    }

}