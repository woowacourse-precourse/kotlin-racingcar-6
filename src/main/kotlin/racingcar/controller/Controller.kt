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
        val carList : List<Car> = inputCarsNames.split(',').map { Car(it) }
        Validator(inputCarsNames, inputRound)

        repeat(inputRound){
            playGame(carList)
            showResult() // 한 라운드 결과
        }
        //최종 위


    }

    private fun readInputCars(): String {
        outputView.printInputNameOfCars()
        return inputView.readUserInput()
    }

    private fun readInputRound(): String {
        outputView.printInputNumberOfAttempts()
        return inputView.readUserInput()
    }

    private fun playGame(carList : List<Car>) {
        carList.forEach { it.goForward()}
    }

    private fun showResult() {
        outputView.printStartOfResultPhrase()

    }

}