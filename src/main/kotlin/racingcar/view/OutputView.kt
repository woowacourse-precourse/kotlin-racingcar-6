package racingcar.view

import racingcar.util.*

class OutputView {
    fun printExecutionResult() {
        println(RESULT_MESSAGE)
    }

    fun printRoundResult(car: String) {
        print(car + COLON)
    }

    fun makeDash(progress: Int) {
        repeat(progress) {
            print(DASH)
        }
        println()
    }

    fun printWinners(winners: List<String>) {
        val winnerNames = winners.joinToString(COMMA + " ")
        println(WINNER_MESSAGE + COLON + "$winnerNames")
    }
}