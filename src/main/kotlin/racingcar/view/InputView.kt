package racingcar.view

import camp.nextstep.edu.missionutils.Console

class InputView {

    fun readUserInput(): String = Console.readLine()

    fun finish() = Console.close()
}