package racingcar.view

import racingcar.domain.Cars

class OutputView(cars: Cars) {
    fun drawDashOnMoveForward(cars: List<Cars>) {
        for (car in cars) {
            print("${car.carName} : ")
            printBar(car.carPosition)
            println()
        }
    }
    private fun printBar(carPosition: Int) {
        repeat(carPosition) { print("-") }
    }
}