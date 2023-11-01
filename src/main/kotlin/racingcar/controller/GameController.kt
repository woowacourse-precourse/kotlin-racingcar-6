package racingcar.controller

import racingcar.model.Car
import racingcar.model.Cars
import racingcar.view.InputView
import racingcar.view.OutputView

class GameController {

    // view
    private val inputView = InputView()
    private val outputView = OutputView()

    // model
    private lateinit var cars: Cars

    fun startGame() {
        outputView.showStartGuide()
        cars = Cars(inputView.cars().map { Car(name = it) })
        cars.validate()

        outputView.showTryCountGuide()
        val tryCount = inputView.tryCount()
        startTurn(tryCount)

        val winners = cars.decideWinner()
        outputView.showResult(winners)
    }

    private fun startTurn(tryCount: Int) {
        outputView.showResultGuide()
        for (i in 1..tryCount) {
            cars.carList.forEach {
                it.moveForward()
            }
            outputView.showRace(cars)
        }
    }
}