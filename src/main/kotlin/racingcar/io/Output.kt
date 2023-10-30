package racingcar.io

import racingcar.model.Car

fun printCarListResult(carList: List<Car>) {
    carList.forEach { car -> println(car.getRacingResultString()) }
    println()
}

fun printWinner(winnerList: List<Car>) {
    print("최종 우승자 : ${winnerList.joinToString(", ")}")
}