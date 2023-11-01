package racingcar.controller

import racingcar.view.InputView
import racingcar.view.OutputView
import racingcar.domain.Validator

class Controller {

    private val inputView = InputView()
    private val outputView = OutputView()
    fun start() {
        val inputCarsNames = readInputCars()
        val inputRound = readInputRound().toInt()
        val listCars = inputCarsNames.split(',').toList()
        Validator(inputCarsNames, inputRound)
        playGame(listCars, inputRound)
        showResult()


    }

    private fun readInputCars(): String {
        outputView.printInputNameOfCars()
        return inputView.readUserInput()
    }

    private fun readInputRound(): String {
        outputView.printInputNumberOfAttempts()
        return inputView.readUserInput()
    }

    private fun playGame( CarsName : List<String>, round : Int) {

    }

    private fun showResult() {
        outputView.printAllRoundsResult()
    }

}