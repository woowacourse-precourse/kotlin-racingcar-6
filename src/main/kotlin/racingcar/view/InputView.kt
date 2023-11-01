package racingcar.view

import camp.nextstep.edu.missionutils.Console


class InputView {
    fun carNameInput(): String {
        return Console.readLine()
    }

    fun tryNameInput(): String {
        return Console.readLine()
    }
}