package racingcar.controller

import racingcar.view.OutputView
class RacingcarController {

    private val outputView = OutputView()

    fun startRacing() {
        outputView.printInputRacingcarName()
    }
}