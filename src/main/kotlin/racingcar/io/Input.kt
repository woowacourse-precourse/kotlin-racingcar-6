package racingcar.io

import camp.nextstep.edu.missionutils.Console
import racingcar.io.checker.ExceptionCheckerInterface

class Input {
    fun getInput(checker: ExceptionCheckerInterface): String {
        val inputString = Console.readLine()

        checker.check(inputString)

        return inputString
    }
}