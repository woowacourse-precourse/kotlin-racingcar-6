package racingcar.controller

import racingcar.view.OutputView
import camp.nextstep.edu.missionutils.Console

class RacingcarController {
    private val outputView = OutputView()

    fun startRacing() {
        outputView.printInputRacingcarName()
        val racingcarName = inputRacingcarName()
        println(racingcarName)
    }

    private fun inputRacingcarName(): String {
        val inputRacingcarName = Console.readLine()
        return inputRacingcarName
    }

}