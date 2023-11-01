package racingcar.functions

import racingcar.Cars
import racingcar.Constants

fun carRace(inputRound: Int, cars: List<Cars>): List<Cars> {
    repeat(inputRound) {
        cars.forEach { it.move() }
        printCarPositions(cars)
        println()
    }
    return cars
}

fun printCarPositions(cars: List<Cars>) {
    cars.forEach { car ->
        println("${car.name} : ${Constants.POSITION_MARK.repeat(car.position)}")
    }
}