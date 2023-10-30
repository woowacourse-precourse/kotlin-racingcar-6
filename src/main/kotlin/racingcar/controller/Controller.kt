package racingcar.controller

import racingcar.model.CarGroup
import racingcar.model.Judge
import racingcar.model.validateNumber
import racingcar.view.InputView
import racingcar.view.OutputView

class Controller {

    private val outputView = OutputView()
    private val inputView = InputView()

    fun start() {
        val participants = getRaceParticipants()
        val attemptNumber = getAttemptNumber()
        val judge = Judge(participants)
        displayRaceResult(attemptNumber, judge)
        inputView.terminated()
    }

    private fun getRaceParticipants(): CarGroup {
        outputView.printInputRaceCarNames()
        return CarGroup.from(inputView.getUserInput())
    }

    private fun getAttemptNumber(): Int {
        outputView.printInputNumberOfAttempts()
        return inputView.getUserInput().validateNumber().getOrThrow().toInt()
    }

    private fun displayRaceResult(attemptNumber: Int, judge: Judge) {
        outputView.printResult()
        repeat(attemptNumber) {
            outputView.printCurrentRaceResult(judge.play())
        }
        outputView.printWinner(judge.getWinner())
    }
}