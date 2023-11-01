package racingcar.controller

import racingcar.model.Car
import racingcar.model.Cars
import racingcar.view.InputView
import racingcar.view.OutputView

class GameController(
    private val inputView: InputView = InputView(),
    private val outputView: OutputView = OutputView(),
) {

    private lateinit var cars: Cars

    fun startGame() {
        outputView.startGuide()
        cars = Cars(inputView.cars().map { Car(name = it) })
        cars.validate()

        outputView.tryCountGuide()
        val tryCount = inputView.tryCount()
        startTurn(tryCount)

        val winners = cars.decideWinner()
        outputView.result(winners)
    }

    private fun startTurn(tryCount: Int) {
        outputView.resultGuide()
        for (i in 1..tryCount) {
            cars.carList.forEach {
                it.moveForward()
            }
            outputView.race(cars)
        }
    }
}