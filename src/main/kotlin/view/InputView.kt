package view

import camp.nextstep.edu.missionutils.Console
import util.Validator

class InputView {
    fun inputCarNames(): String {
        val input: String = Console.readLine()
        Validator().checkInputEmpty(input)
        return input
    }

    fun inputTryNum(): String {
        val input: String = Console.readLine()
        Validator().checkTryNum(input)
        return input
    }
}