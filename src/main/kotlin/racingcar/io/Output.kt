package racingcar.io

import racingcar.model.Car

fun printCarListResult(carList: List<Car>) {
    carList.forEach { car ->
        printCarResult(car)
    }
    println()
}

fun printCarResult(car: Car) = println("${car.name} : ${car.racingResult}")

fun printWinner(winnerList: List<Car>) {
    print("최종 우승자 : ${winnerList.joinToString(", ")}")
}