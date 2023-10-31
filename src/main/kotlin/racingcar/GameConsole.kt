package racingcar

import utils.Constants

class GameConsole {

    fun printRoundResultTitle() {
        println()
        println(Constants.ROUND_RESULT_MSG)
    }

    fun printRoundResult(carList: List<Car>) {
        carList.forEach { car -> println(car) }
        println()
    }

    fun printWinner(winnerList: List<Car>) {
        print(Constants.WINNER_RESULT_TITLE)
        print(winnerList.joinToString(", ") { it.name })
    }
}