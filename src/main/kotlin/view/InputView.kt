package view

import camp.nextstep.edu.missionutils.Console
import util.Validator

class InputView {
    fun inputCarNames() : String {
        val input = Console.readLine()
        Validator().checkInputNull(input)
        return input
    }
}