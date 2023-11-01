package racingcar.view

import racingcar.utils.Constants.RESULT_MESSAGE
import racingcar.utils.Constants.START_MESSAGE
import racingcar.utils.Constants.TRIAL_MESSAGE
import racingcar.utils.Constants.WINNER_MESSAGE

object OutputView {
    fun printStartMessage() {
        println(START_MESSAGE)
    }

    fun printTrialMessage() {
        println(TRIAL_MESSAGE)
    }

    fun printRaceWinner(winner: List<String>) {
        print(WINNER_MESSAGE)
        println(winner.joinToString(","))
    }

    fun printResultMessage() {
        print(RESULT_MESSAGE)
    }
}