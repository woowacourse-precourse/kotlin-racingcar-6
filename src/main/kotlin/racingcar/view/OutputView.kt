package racingcar.view

import racingcar.model.Car
import racingcar.util.Constants

class OutputView {
    fun printRaceStart(raceStartMsg: String) {
        println(raceStartMsg)
    }

    fun requestAttemptsNumber(numberAttemptsMsg: String) {
        println(numberAttemptsMsg)
    }

    fun printMatchProgress(cars: List<Car>) {
        cars.forEach { car -> println("${car.name} : ${Constants.DISTANCE_MSG.repeat(car.distance)}") }
        println()
    }

    fun printWinner(winnerNames: String) {
        println("${Constants.WINNER_MSG}$winnerNames")
    }
}