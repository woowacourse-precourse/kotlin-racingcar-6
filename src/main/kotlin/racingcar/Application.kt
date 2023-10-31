package racingcar

import racingcar.model.RacingGame
import racingcar.view.InputView
import racingcar.view.OutputView

fun main() {
    val inputView = InputView()
    val racingGame = RacingGame()
    val outputView = OutputView()
    val racingCars = inputView.prepareToPlay()

    racingGame.playGame(racingCars)
    outputView.gameResult(racingCars.carList)
}
