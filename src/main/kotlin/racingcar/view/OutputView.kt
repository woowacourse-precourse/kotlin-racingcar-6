package racingcar.view

import racingcar.model.Cars
import racingcar.model.Winner

class OutputView {
    fun printRoundResult(cars: Cars) {
        for (car in cars.carList) {
            println("${car.name} : ${"-".repeat(car.score)}")
        }
        println()
    }

    fun printWinner(winner: Winner) = println("최종 우승자 : ${winner.winnerList.joinToString(", ")}")
}