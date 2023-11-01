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
        race(racingCarNames = racingCarNames, attemptsNum = attemptsNum) { racingCars ->
            val winners = racingCarGame.getWinners(racingCars = racingCars)
            outputView.printGameWinner(winners = winners)
        }
    }

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

    private inline fun race(racingCarNames: List<String>, attemptsNum: Int, action: (List<RacingCar>) -> Unit) {
        var racingCars = racingCarGame.createRacingCars(racingCars = racingCarNames)
        outputView.printGameResult()

        repeat(attemptsNum) {
            racingCars = racingCarGame.moveRacingCars(racingCars = racingCars)
            outputView.printCarRaceResults(racingCars = racingCars)
        }
        action(racingCars)
    }
}