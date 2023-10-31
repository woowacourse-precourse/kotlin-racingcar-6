package racingcar

import racingcar.Constants.CAR_NAME_SEPARATOR
import racingcar.Constants.MESSAGE_ASK_CAR_NAME
import racingcar.Constants.MESSAGE_ASK_MOVE_COUNT
import racingcar.Constants.MESSAGE_FINAL_WINNER
import racingcar.Constants.PROGRESS_BAR

object GameConsole {

    fun printPosition(name: String, position: Int) {
        println("$name : ${PROGRESS_BAR.repeat(position)}")
    }

    fun printWinnerNames(winnerNames: List<String>) {
        val winner = winnerNames.joinToString(CAR_NAME_SEPARATOR)
        println(MESSAGE_FINAL_WINNER + winner)
    }

    fun printCarNamePrompt() {
        println(MESSAGE_ASK_CAR_NAME)
    }

    fun printMoveCountPrompt() {
        println(MESSAGE_ASK_MOVE_COUNT)
    }
}