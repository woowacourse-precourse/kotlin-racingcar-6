package racingcar.controller

import racingcar.model.Attempt
import racingcar.model.Judge
import racingcar.model.RaceParticipants
import racingcar.model.validateNumber
import racingcar.view.InputView
import racingcar.view.OutputView

class Controller {

    private val outputView = OutputView()
    private val inputView = InputView()

    fun start() {
        val participants = getRaceParticipants()
        val attemptNumber = getAttemptNumber()
        val judge = Judge(participants, attemptNumber)
        displayRaceResult(judge, attemptNumber)
        inputView.terminated()
    }

    private fun getRaceParticipants(): RaceParticipants {
        outputView.printInputRaceCarNames()
        return RaceParticipants.from(inputView.getUserInput())
    }

    private fun getAttemptNumber(): Int {
        outputView.printInputNumberOfAttempts()
        return inputView.getUserInput().validateNumber(containsDigit = false).getOrThrow().toInt()
    }

    private fun displayRaceResult(judge: Judge, lastAttempt: Attempt) {
        val raceResult = judge.play()
        outputView.printCurrentRaceResult(raceResult, lastAttempt)
        outputView.printWinner(judge.getWinner())
    }
}