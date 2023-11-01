package racingcar.controller

import racingcar.view.InputView
import racingcar.view.OutputView

class Controller {

    private val inputView = InputView()
    private val outputView = OutputView()
    fun start() {
        val inputCars = readInputCars()
        val inputRound = readInputRound()

    }

    private fun readInputCars() :String {
        outputView.printInputNameOfCars()
        return inputView.readUserInput()
    }

    private fun readInputRound() :String {
        outputView.printInputNumberOfAttempts()
        return inputView.readUserInput()
    }

}