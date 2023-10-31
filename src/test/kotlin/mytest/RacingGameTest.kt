package mytest

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import racingcar.Exceptions.inputCarNameException
import racingcar.Exceptions.inputTryCountException
import racingcar.controller.RacingGameController
import racingcar.model.RacingGameModel
import racingcar.view.ConsoleView
import java.io.ByteArrayOutputStream
import java.io.PrintStream

class RacingGameTest {
    @Test
    fun `자동차 이름 입력 예외처리 테스트`() {
        // Given
        val invalidInputs = listOf("", "pobi, ,jun,hoit,crong", " ", "pobi,woni, ", "pobi,woni, dscrong")

        // When & Then
        for (input in invalidInputs) {
            assertThrows<IllegalArgumentException> {
                inputCarNameException(input)
            }
        }
    }

    @Test
    fun `게임시도 횟수 입력 예외처리 테스트`() {
        // Given
        val invalidInputs = listOf("", "0", "-5", "abc")

        // When & Then
        for (input in invalidInputs) {
            assertThrows<IllegalArgumentException> {
                inputTryCountException(input)
            }
        }
    }


    @Test
    fun `printRound 함수 테스트`() {
        // Given
        val outputStream = ByteArrayOutputStream()
        System.setOut(PrintStream(outputStream))

        // When
        ConsoleView.printRound(3)

        // Then
        assertThat(outputStream.toString().trim()).isEqualTo("3 라운드")
    }

    @Test
    fun `RacingGameModel Car 클래스 move 함수 테스트`() {
        // Given
        val car = RacingGameModel.Car("car1")

        // When
        car.move()

        // Then
        assertThat(car.distance).isIn(0, 1)
    }

    @Test
    fun `RacingGameModel RacingGame 클래스 playRound 함수 테스트`() {
        // Given
        val carNames = listOf("car1", "car2", "car3")
        val tryCount = 5
        val racingGame = RacingGameModel.RacingGame(carNames, tryCount)

        // When
        racingGame.playRound()

        // Then
        val results = racingGame.getResults()
        assertThat(results).hasSize(3)
        assertThat(results.values).allMatch { it in 0..1 }
    }

    @Test
    fun `RacingGameModel RacingGame 클래스 getResults 함수 테스트`() {
        // Given
        val carNames = listOf("car1", "car2", "car3")
        val tryCount = 5
        val racingGame = RacingGameModel.RacingGame(carNames, tryCount)

        // When
        racingGame.playRound()
        val results = racingGame.getResults()

        // Then
        assertThat(results).hasSize(3)
        assertThat(results.values).allMatch { it in 0..1 }
    }

    @Test
    fun `RacingGameController getWinners 함수 테스트`() {
        // Given
        val results = mapOf("car1" to 5, "car2" to 3, "car3" to 5)

        // When
        val winners = RacingGameController.getWinners(results)

        // Then
        assertThat(winners).containsExactlyInAnyOrder("car1", "car3")
    }
}

