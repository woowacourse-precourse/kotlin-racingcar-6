package racingcar

import camp.nextstep.edu.missionutils.Console
import racingcar.raceModel.Car

class RaceView {
    fun input(prompt: String): String {
        println(prompt)
        return Console.readLine()
    }

    fun showCars(cars: List<Car>) {
        cars.forEach { println(it) }
    }

    fun showWinners(winners: List<String>) {
        println("최종 우승자 : ${winners.joinToString(", ")}")
    }
}