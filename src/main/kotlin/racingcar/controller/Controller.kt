package racingcar.controller

import racingcar.domain.Car
import racingcar.view.InputView
import racingcar.view.OutputView
import racingcar.domain.Validator

class Controller {
    private val inputView = InputView()
    private val outputView = OutputView()
    fun start() {
        val inputCarsNames = readInputCars()
        val inputRound = readInputRound().toInt()
        val carList: List<Car> = inputCarsNames.split(',').map { Car(it) }
        Validator(inputCarsNames, inputRound)
        outputView.printStartOfResultPhrase()

        repeat(inputRound) {
            playGame(carList)
            showResult(carList)
            println()
        }

        showWinners(carList)

        inputView.finish()
    }

    private fun readInputCars(): String {
        outputView.printInputNameOfCars()
        return inputView.readUserInput()
    }

    private fun readInputRound(): String {
        outputView.printInputNumberOfAttempts()
        return inputView.readUserInput()
    }

    private fun playGame(carList: List<Car>) {
        carList.forEach { it.goForward() }
    }

    private fun showResult(carList: List<Car>) {
        carList.forEach { outputView.printRoundResultFormat(it.carName, it.forward) }
    }

    private fun showWinners(carList: List<Car>) {
        outputView.printWinnerFormat(decideWinners(carList))
    }

    private fun decideWinners(carList: List<Car>): List<String> {
        val maxForward = carList.maxByOrNull { it.forward }?.forward
        return carList.filter { it.forward == maxForward }.map { it.carName }
    }

}