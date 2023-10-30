package racingcar.controller

import racingcar.view.InputView

object RacingCarGameController {
    fun start() {
        InputView.readNames()
        InputView.readCount()
    }
}
