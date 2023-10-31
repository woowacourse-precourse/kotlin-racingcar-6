package racingcar

import utils.Constants.WINNER_RESULT_TITLE
import utils.Constants.ROUND_RESULT_MSG

class GameConsole {

    fun printRoundResultTitle() {
        println()
        println(ROUND_RESULT_MSG)
    }

    fun printRoundResult(carList: List<Car>) {
        carList.forEach { car -> println(car) }
        println()
    }

    fun printWinner(winnerList: List<Car>) {
        print(WINNER_RESULT_TITLE)
        print(winnerList.joinToString(", ") { it.name })
    }
}