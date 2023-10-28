package racingcar

import racingcar.controller.RacingCarController
import racingcar.view.InputView

fun main() {
    val racingCarController = RacingCarController(InputView())
    racingCarController.racingRun()
}
