package racingcar

import racingcar.controller.RacingCarGameController
import racingcar.controller.RacingCarGameImpl
import racingcar.view.InputView
import racingcar.view.OutputView

fun main() {
    RacingCarGameController(
        inputView = InputView(),
        outputView = OutputView(),
        racingCarGame = RacingCarGameImpl(),
    ).playGame()
}
