package racingcar.view

import racingcar.model.RacingCar

class OutputView {
    fun printResultMessage() = println("\n실행 결과")

    fun printResult(racingCars: List<RacingCar>) {
        for (car in racingCars) {
            println("${car.name} : " + "-".repeat(car.forward))
        }
        println()
    }
}