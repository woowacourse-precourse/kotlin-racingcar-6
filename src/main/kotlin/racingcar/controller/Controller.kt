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
        val round = getRoundNumber()
        val judge = Judge(participants, round)
        displayRaceResult(judge, round)
        inputView.terminated()
    }

    private fun getRaceParticipants(): RaceParticipants {
        outputView.printInputRaceCarNames()
        return RaceParticipants.from(inputView.getUserInput())
    }

    private fun getRoundNumber(): Int {
        outputView.printInputNumberOfAttempts()
        return inputView.getUserInput().validatePositiveNumber().getOrThrow().toInt()
    }

    private fun displayRaceResult(judge: Judge, lastRound: Round) {
        val raceResult = judge.startRace()
        outputView.printCurrentRaceResult(raceResult, lastRound)
        outputView.printWinner(judge.getWinner())
    }
}