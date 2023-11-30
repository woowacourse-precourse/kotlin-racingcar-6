package racingcar.controller

import racingcar.model.Cars
import racingcar.model.MoveStrategy
import racingcar.view.InputView
import racingcar.view.OutputView

class GameController(private val moveStrategy: MoveStrategy) {

    private val inputView = InputView()
    private val outputView = OutputView()

    fun start() {
        val cars = (inputView.readCars()).toCars()
        val tryCount = inputView.readTryCount()

        outputView.showResultHeader()
        moveCars(tryCount, cars)
        outputView.showTotalWinner(cars.getWinners())
    }

    private fun moveCars(tryCount: Int, cars: Cars) {
        repeat(tryCount) {
            cars.cars.forEach { car ->
                moveStrategy.moveForward(car)
            }
            outputView.showTryResult(cars)
        }
    }

}