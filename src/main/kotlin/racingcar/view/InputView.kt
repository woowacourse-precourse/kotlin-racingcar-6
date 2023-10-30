package racingcar.view

import racingcar.Constants

object InputView {
    fun readNames(): List<String> {
        print(Constants.INPUT_MESSAGE)
        val input = readLine() ?: throw IllegalArgumentException(Constants.EMPTY_INPUT_ERROR_MESSAGE)
        return input.split(",")
    }

}
