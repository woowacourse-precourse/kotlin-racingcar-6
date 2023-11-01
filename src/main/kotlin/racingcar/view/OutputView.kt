package racingcar.view

import racingcar.utils.Constants.WINNER_MESSAGE

object OutputView {

    fun printRaceWinner(winner: List<String>) {
        print(WINNER_MESSAGE)
        println(winner.joinToString(","))
    }

    fun printErrorMessage() {

    }
}