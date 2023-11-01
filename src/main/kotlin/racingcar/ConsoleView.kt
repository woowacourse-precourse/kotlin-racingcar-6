package racingcar

import camp.nextstep.edu.missionutils.Console

class ConsoleView {
    fun displayCarProgress(cars: List<Car>) {
        for (car in cars) {
            println("${car.name} : " + "-".repeat(car.distance))
        }
        println()
    }

    fun displayFinalWinner(winners: List<Car>) {
        val winnerList = winners.joinToString(", ") { it.name }
        println("최종 우승자 : $winnerList")
    }

    fun promptUser(message: String): String {
        println(message)
        return Console.readLine()
    }
}
