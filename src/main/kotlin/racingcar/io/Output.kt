package racingcar.io

import racingcar.model.Car

fun printCarsResult(cars: List<Car>) {
    cars.forEach { car -> println(car.getRacingResultString()) }
    println()
}

fun printWinners(winners: List<Car>) {
    print("최종 우승자 : ${winners.joinToString(", ")}")
}