package racingcar.controller

import racingcar.model.RacingCar
import racingcar.view.InputView
import racingcar.view.OutputView

class RacingCarGameController(
    private val inputView: InputView,
    private val outputView: OutputView,
    private val racingCarGame: RacingCarGame,
) {

    fun playGame() {
        val racingCarNames = getRacingCarNames()
    private fun getRacingCarNames(): List<String> {
        outputView.printCarNamePrompt()
        return inputView.inputRacingCarNames()
    }
    }
}