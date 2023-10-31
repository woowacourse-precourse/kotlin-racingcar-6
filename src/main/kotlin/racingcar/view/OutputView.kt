package racingcar.view

import racingcar.car.Car

object OutputView {
    private const val COLON = ":"
    private const val ENTER_NAMES_OF_CARS = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)"

    fun enterNamesOfCars() {
        println(ENTER_NAMES_OF_CARS)
    }

    fun executionResult(cars: List<Car>) {
        for (car in cars) {
            println("${car.name} $COLON ${car.currentPosition}")
        }
    }
}