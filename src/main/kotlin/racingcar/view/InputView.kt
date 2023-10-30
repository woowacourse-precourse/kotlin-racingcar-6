package racingcar.view

import camp.nextstep.edu.missionutils.Console

class InputView {

    fun getUserInput(): String = Console.readLine()

    fun terminated() = Console.close()
}