package racingcar

import racingcar.controller.RacingCarController
import racingcar.domain.Cars
import racingcar.view.InputView
import racingcar.view.OutputView

fun main() {
    val racingCarController = RacingCarController(InputView(), OutputView(Cars("")))
    racingCarController.racingRun()
}
