package racingcar.controller

import camp.nextstep.edu.missionutils.Console
import racingcar.view.InputView

class RacingCarController {

    private val inputView = InputView()
    fun playGame() {
        inputView.printInputCarName()
        val userList = Console.readLine().split(",")
    }
}