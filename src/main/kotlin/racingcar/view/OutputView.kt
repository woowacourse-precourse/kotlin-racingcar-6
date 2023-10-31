package racingcar.view

import racingcar.car.Car

object OutputView {
    private const val COLON = ":"

    fun executionResult(cars: List<Car>) {
        for (car in cars) {
            println("${car.name} $COLON ${car.currentPosition}")
        }
    }
}