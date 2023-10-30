package racingcar.view

import racingcar.Constants

object InputView {
    fun readNames(): List<String> {
        print(Constants.INPUT_MESSAGE)
        val input = readLine() ?: throw IllegalArgumentException(Constants.EMPTY_INPUT_ERROR_MESSAGE)
        return input.split(",")
    }

    fun readCount(): Int {
        print(Constants.INPUT_COUNT_MESSAGE)
        val input = readLine() ?: throw IllegalArgumentException(Constants.EMPTY_INPUT_ERROR_MESSAGE)
        return input.toInt()
    }
}
