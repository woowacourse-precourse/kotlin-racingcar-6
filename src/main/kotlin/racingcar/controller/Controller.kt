package racingcar.controller

import racingcar.model.Judge
import racingcar.model.RaceParticipants
import racingcar.model.Round
import racingcar.model.validatePositiveNumber
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
        return inputView.getUserInput().validatePositiveNumber().getOrThrow().toInt()
    }

    private fun displayRaceResult(judge: Judge, lastRound: Round) {
        val raceResult = judge.startRace()
        outputView.printCurrentRaceResult(raceResult, lastRound)
        outputView.printWinner(judge.getWinner())
    }
}