package racingcar.view

import racingcar.model.Cars

class OutputView {
    fun printRoundResult(cars: Cars) {
        for (car in cars.carList) {
            println("${car.name} : ${"-".repeat(car.score)}")
        }
        println()
    }
}