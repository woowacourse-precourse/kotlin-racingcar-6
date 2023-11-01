package racingcar.controller

import racingcar.model.Judge
import racingcar.model.Round
import racingcar.view.InputView
import racingcar.view.OutputView

class Controller {

    private val outputView = OutputView()
    private val inputView = InputView()

    fun start() {
        val participants = getRaceParticipantsInput()
        val round = getRoundInput()
        val judge = Judge.of(participants, round)
        displayRaceResult(judge, round)
        inputView.terminated()
    }

    private fun getRaceParticipantsInput(): String {
        outputView.printInputRaceCarNames()
        return inputView.getUserInput()
    }

    private fun getRoundInput(): String {
        outputView.printInputNumberOfAttempts()
        return inputView.getUserInput()
    }

    private fun displayRaceResult(judge: Judge, roundString: String) {
        val raceResult = judge.startRace()
        outputView.printCurrentRaceResult(raceResult, Round.from(roundString))
        outputView.printWinner(judge.getWinner())
    }
}