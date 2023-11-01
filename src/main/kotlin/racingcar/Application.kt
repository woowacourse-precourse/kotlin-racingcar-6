package racingcar

import controller.RacingGame
import view.InputView
import view.OutputView

fun main() {
    val racingGame = RacingGame(OutputView(), InputView())
    racingGame.runGame()
}

