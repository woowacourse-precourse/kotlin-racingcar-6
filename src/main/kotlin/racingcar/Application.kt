package racingcar

import racingcar.model.RacingGame
import racingcar.view.InputView
import racingcar.view.OutputView

fun main() {
    val inputView = InputView()
    val outputView = OutputView()
    val racingGame = RacingGame()
    val racingCars = inputView.prepareToPlay()

    racingGame.playGame(racingCars)
    outputView.gameResult()
}
