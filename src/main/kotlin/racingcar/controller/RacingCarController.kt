package racingcar.controller

import racingcar.domain.RacingCars
import racingcar.service.RacingCarService
import racingcar.view.PrintOutputView
import racingcar.view.ReadUserInputView

class RacingCarController(
    private val userInputView: ReadUserInputView,
    private val outputView: PrintOutputView,
    private val service: RacingCarService
) {
    fun play() {
        val userInputCarNames = requireCarNames()
        service.initGame(userInputCarNames)
        val userInputAttemptCount = requireAttemptCount()
        playGame(userInputAttemptCount)
    }

    private fun requireCarNames(): RacingCars {
        outputView.printRequireCarNames()
        return userInputView.readCarNames()
    }

    private fun requireAttemptCount(): Int {
        outputView.printRequireAttemptCount()
        return userInputView.readAttemptNumber()
    }

    private fun playGame(attemptCount: Int) {
        repeat(attemptCount) {
            val attemptResult = service.moveRacingCars()
            outputView.printAttemptResult(attemptResult)
        }
        printWinner()
    }

    private fun printWinner() {
        val winners = service.calculateRacingResult()

        outputView.printWinner(winners)
    }

}