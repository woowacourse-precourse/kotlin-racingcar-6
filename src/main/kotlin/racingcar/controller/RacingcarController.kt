package racingcar.controller

import racingcar.view.OutputView
import camp.nextstep.edu.missionutils.Console

class RacingcarController {
    private val outputView = OutputView()

    fun startRacing() {
        outputView.printInputRacingcarName()
        val racingcarName = inputRacingcarName()
        outputView.printTryNumber()
        val tryNumber = inputTryNumber()
    }

    private fun inputRacingcarName(): List<String> {
        val inputRacingcarName = Console.readLine()
        val racingcarName = splitRacingcarName(inputRacingcarName)
        racingcarName.forEach { name ->
            checkCarNameLength(name)
        }
        return racingcarName
    }

    private fun splitRacingcarName(racingcarName: String): List<String> = racingcarName.split(",")

    private fun inputTryNumber(): String {
        val tryNumber = Console.readLine()
        checkTryNumber(tryNumber)
        return tryNumber
    }

    private fun callException(): Nothing = throw IllegalArgumentException("잘못된 값을 입력하였습니다.")

    private fun checkCarNameLength(racingcarName: String) {
        if (racingcarName.length > 5) callException()
    }

    private fun checkTryNumber(tryNumber: String) {
        tryNumber.toIntOrNull() ?: callException()
    }
}