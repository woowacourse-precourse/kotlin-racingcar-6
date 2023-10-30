package racingcar

import racingcar.controller.RacingCarController
import racingcar.service.RacingCarService
import racingcar.view.PrintOutputView
import racingcar.view.ReadUserInputView

fun main() {
    RacingCarController(ReadUserInputView(), PrintOutputView(), RacingCarService()).play()
}
