package racingcar.view

import racingcar.INPUT_MESSAGE_CAR_NAME
import racingcar.INPUT_MESSAGE_ROUND_NUMBER

class InputView {
    fun inputCarNames(): String {
        println(INPUT_MESSAGE_CAR_NAME)
        val inputString = readLine()!!
        return inputString
    }

    fun inputRoundNum(): Int {
        println(INPUT_MESSAGE_ROUND_NUMBER)
        val inputNumber = readLine()!!.toInt()
        return inputNumber
    }
}