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
        outputView.printInputRaceCarNames()
        val cars = CarGroup.from(inputView.getUserInput())

        outputView.printInputNumberOfAttempts()
        val number = inputView.getUserInput().validateNumber().getOrThrow().toInt()

        val judge = Judge(cars)
        repeat(number) {
            outputView.printAllRaceResults(judge.play())
        }
        outputView.printWinner(judge.getWinner())
        inputView.terminated()
    }
}