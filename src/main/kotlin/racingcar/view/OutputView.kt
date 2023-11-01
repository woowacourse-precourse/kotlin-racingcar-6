package racingcar.view

import racingcar.util.*

class OutputView {
    fun progressResult() {
        println(RESULT_MESSAGE)
    }

    fun roundResult(car: String) {
        print(car + COLON)
    }

    fun makeDash(progress: Int) {
        repeat(progress) {
            print(DASH)
        }
        println()
    }

    fun singleWinner(winner: String) {
        println(WINNER_MESSAGE + COLON + "$winner")
    }

    fun multipleWinners(winners: List<String>) {
        val winnerNames = winners.joinToString(COMMA + " ")
        println(WINNER_MESSAGE + COLON + "$winnerNames")
    }
}