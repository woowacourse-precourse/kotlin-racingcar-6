package controller

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.mockito.Mockito.*
import racingcar.controller.GameController
import racingcar.model.Car
import racingcar.view.InputView
import racingcar.view.OutputView

class GameControllerTest {
    val inputView = mock(InputView::class.java)
    val outputView = mock(OutputView::class.java)
    val gameController = GameController(inputView, outputView)

    @Test
    fun `runGame 실행 시 setGame과 gameResult가 호출된다`() {
        doReturn(listOf("car")).`when`(inputView).inputName()
        doReturn(3).`when`(inputView).inputCount()
        gameController.runGame()

        verify(inputView, times(1)).inputName()
        verify(inputView, times(1)).inputCount()
        verify(outputView, times(1)).winnerOutput(anyString())
    }

    @Test
    fun `단독 우승자가 정상적으로 출력된다`() {
        val gameController = GameController()
        gameController.car.add(Car("pobi").apply { score = 3 })
        gameController.car.add(Car("jun").apply { score = 2 })
        gameController.car.add(Car("bob").apply { score = 1 })

        val winner = gameController.setWinner()

        assertThat(winner).isEqualTo("pobi")
    }

    @Test
    fun `공동 우승자가 정상적으로 출력된다`() {
        val gameController = GameController()
        gameController.car.add(Car("pobi").apply { score = 3 })
        gameController.car.add(Car("jun").apply { score = 3 })
        gameController.car.add(Car("bob").apply { score = 1 })

        val winner = gameController.setWinner()

        assertThat(winner).isEqualTo("pobi,jun")
    }
}