package racingcarTest

import org.junit.jupiter.api.Test
import org.assertj.core.api.Assertions.assertThat

import racingcar.Car
import racingcar.RacingGame

import java.io.ByteArrayOutputStream
import java.io.PrintStream

class RacingGameTest {

    @Test
    fun `playGame should move cars for the specified number of rounds`() {
        val cars = listOf(Car("pobi"), Car("woni"), Car("jun"))
        val racingGame = RacingGame(cars, 5)

        racingGame.playGame()

        assertThat(cars).allMatch { it.position in 0..5 }
    }

    @Test
    fun `printWinners should display the winner(s)`() {
        val cars = listOf(Car("pobi"), Car("woni"), Car("jun"))
        cars[0].position = 5
        cars[1].position = 3
        cars[2].position = 5
        val racingGame = RacingGame(cars, 5)

        val outputStreamCaptor = System.out

        try {
            val capturedOutput = ByteArrayOutputStream()
            System.setOut(PrintStream(capturedOutput))

            racingGame.printWinners()

            val expectedOutput = "최종 우승자: pobi, jun\n"
            assertThat(capturedOutput.toString()).isEqualTo(expectedOutput)
        } finally {
            System.setOut(outputStreamCaptor)
        }
    }
}
