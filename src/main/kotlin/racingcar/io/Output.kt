package racingcar.io

import racingcar.constants.Delimiter
import racingcar.constants.Output
import racingcar.model.Car

fun printCarsResult(cars: List<Car>) {
    cars.forEach { car -> println(car.getRacingResultString()) }
    println()
}

fun printWinners(winners: List<Car>) {
    print(Output.WINNER)
    print(winners.joinToString(Delimiter.WINNER.toString())) // 문자열 구분자 ", "
}