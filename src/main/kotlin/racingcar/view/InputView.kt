package racingcar.view

import racingcar.Constants
import camp.nextstep.edu.missionutils.Console

object InputView {
    fun readNames(): List<String> {
        OutputView.startReadNames()
        val input = Console.readLine() ?: throw IllegalArgumentException(Constants.EMPTY_INPUT_ERROR_MESSAGE)
        return input.split(",")
    }

    fun readCount(): Int {
        OutputView.startReadCount()
        val input = Console.readLine() ?: throw IllegalArgumentException(Constants.EMPTY_INPUT_ERROR_MESSAGE)
        return input.toInt()
    }
}
