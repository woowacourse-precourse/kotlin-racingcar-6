package racingcar

import racingcar.controller.RacingCarController
import racingcar.view.RacingCarView

fun main() {
    var racingCarView = RacingCarView()
    var racingCarController = RacingCarController(racingCarView)
    racingCarController.run()
}
