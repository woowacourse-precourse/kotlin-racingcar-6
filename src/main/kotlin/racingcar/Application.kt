package racingcar

import racingcar.controller.RacingCarController
import racingcar.view.PrintOutputView
import racingcar.view.ReadUserInputView

fun main() {
    RacingCarController(ReadUserInputView(), PrintOutputView()).play()
}
