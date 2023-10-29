package racingcar.controller

import racingcar.view.OutputView
import camp.nextstep.edu.missionutils.Console
import racingcar.model.GenerateRandomNumber
import racingcar.model.MoveCar

class RacingcarController {
    private val outputView = OutputView()
    private val moveCar = MoveCar()

    fun startRacing() {
        outputView.printInputRacingcarName()
        val racingcarName = inputRacingcarName()
        outputView.printTryNumber()
        val tryNumber = inputTryNumber()
        outputView.printResult()
        race(racingcarName, tryNumber)

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

    private fun inputTryNumber(): Int {
        val tryNumber = Console.readLine()
        checkTryNumber(tryNumber)
        return tryNumber.toInt()
    }

    private fun callException(): Nothing = throw IllegalArgumentException("잘못된 값을 입력하였습니다.")

    private fun checkCarNameLength(racingcarName: String) {
        if (racingcarName.length > 5) callException()
    }

    private fun checkTryNumber(tryNumber: String) {
        tryNumber.toIntOrNull() ?: callException()
    }

    fun race(racingcarName: List<String>, tryNumber: Int) {
        var carScore = racingcarName.associateWith { 0 }.toMutableMap()

        for (i in 0 until tryNumber) {
            moveCar.calculateScore(carScore)
            outputView.printCarScore(carScore)
        }
    }
}