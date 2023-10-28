package racingcar.view

import camp.nextstep.edu.missionutils.Console


class InputView {
    fun carNameInput():String{
        val names : String = Console.readLine()
        return names
    }
}