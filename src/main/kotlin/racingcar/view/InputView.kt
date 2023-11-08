package racingcar.view

import camp.nextstep.edu.missionutils.Console

class InputView {
    fun getCarList() = Console.readLine().split(",")
    fun getAttemptsNumber(): String = Console.readLine().trim()
}