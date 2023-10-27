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
        val attemptsNum = getAttemptsNum()
    private fun getRacingCarNames(): List<String> {
        outputView.printCarNamePrompt()
        return inputView.inputRacingCarNames()
    }

    private fun getAttemptsNum(): Int {
        outputView.printAttemptsPrompt()
        val attemptsNum = inputView.inputAttemptsNum()
        outputView.printEmptyLine()
        return attemptsNum
    }
    }
}