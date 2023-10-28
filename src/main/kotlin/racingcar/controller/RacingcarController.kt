package racingcar.controller

import racingcar.view.OutputView
import camp.nextstep.edu.missionutils.Console

class RacingcarController {
    private val outputView = OutputView()

    fun startRacing() {
        outputView.printInputRacingcarName()
        val racingcarName = inputRacingcarName()
        outputView.printTryNumber()

    }

    private fun inputRacingcarName(): List<String> {
        val inputRacingcarName = Console.readLine()
        val racingcarName = splitRacingcarName(inputRacingcarName)
        return racingcarName
    }

    fun splitRacingcarName(racingcarName: String): List<String> = racingcarName.split(",")

}