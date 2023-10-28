package racingcar.controller

import racingcar.service.RacingCarService
import racingcar.view.PrintOutputView
import racingcar.view.ReadUserInputView

class RacingCarController(
    private val userInputView: ReadUserInputView,
    private val outputView: PrintOutputView
) {
    fun play() {
        val racingCarService = RacingCarService()
        outputView.printRequireCarNames()
        val userInputCarNames = userInputView.readCarNames()
        outputView.printRequireAttemptCount()
        racingCarService.initGame(userInputCarNames)
        val userInputAttemptCount = userInputView.readAttemptNumber()
        playGame(racingCarService, userInputAttemptCount)
    }

    private fun playGame(racingCarService: RacingCarService, attemptCount: Int) {
        for (i in 0 until attemptCount) {
            val attemptResult = racingCarService.moveRacingCars()
            outputView.printAttemptResult(attemptResult)
        }
        printWinner(racingCarService)
    }

    private fun printWinner(racingCarService: RacingCarService) {
        val winners = racingCarService.calculateRacingResult()
        if (winners.getWinners().size == SOLE_WINNER_NUMBER) {
            outputView.printSoleWinner(winners)
            return
        }
        outputView.printJointWinner(winners)
    }

    companion object {
        private const val SOLE_WINNER_NUMBER = 1
    }
}