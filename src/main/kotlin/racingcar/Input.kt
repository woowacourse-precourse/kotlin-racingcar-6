package racingcar

import camp.nextstep.edu.missionutils.Console

class Input {
    fun getInput(inputType: InputEnum): String {
        val inputString = Console.readLine()

        inputType.exceptionChecker.check(inputString)

        return inputString
    }
}