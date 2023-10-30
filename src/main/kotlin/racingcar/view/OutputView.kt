package racingcar.view

import racingcar.Constants

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
}
