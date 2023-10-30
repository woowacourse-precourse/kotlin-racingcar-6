package racingcar.view

import racingcar.domain.Constants

object OutputView {
    fun startReadNames() {
        println(Constants.INPUT_MESSAGE)
    }

    fun startReadCount() {
        println(Constants.INPUT_COUNT_MESSAGE)
    }

    fun showResult(carName: String, position: Int) {
        println("$carName : ${Constants.POSITION_SYMBOL.repeat(position)}")
    }

    fun runMessage() {
        println(Constants.RUN_MESSAGE)
    }

    fun showWinners(winners: List<String>) {
        println("${Constants.WINNER_MESSAGE}${winners.joinToString(Constants.NEXT_WINNER)}")
    }
}
