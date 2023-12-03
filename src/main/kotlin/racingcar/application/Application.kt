package racingcar.application

import racingcar.controller.RacingCarGame
import racingcar.presentation.InputView
import racingcar.presentation.OutputView

fun main() {
    val racingCarGame = RacingCarGame(
        inputView = InputView(),
        outputView = OutputView(),
    )
    racingCarGame.play()
}