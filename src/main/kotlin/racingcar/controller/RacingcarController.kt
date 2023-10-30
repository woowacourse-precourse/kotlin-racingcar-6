package racingcar.controller

import racingcar.view.OutputView
import camp.nextstep.edu.missionutils.Console
import racingcar.model.GenerateRandomNumber
import racingcar.model.MoveCar
import racingcar.model.Winner

class RacingcarController {
    private val outputView = OutputView()
    private val moveCar = MoveCar()
    private val winner = Winner()

    fun startRacing() {
        val racingcarName = inputRacingcarName()
        val tryNumber = inputTryNumber()
        race(racingcarName, tryNumber)
    }

    private fun inputRacingcarName(): List<String> {
        outputView.printInputRacingcarName()
        val inputRacingcarName = Console.readLine()
        val racingcarName = splitRacingcarName(inputRacingcarName)
        racingcarName.forEach { name ->
            checkCarNameLength(name)
        }
        return racingcarName
    }

    fun splitRacingcarName(racingcarName: String): List<String> = racingcarName.split(",")

    private fun inputTryNumber(): Int {
        outputView.printTryNumber()
        val tryNumber = Console.readLine()
        checkTryNumber(tryNumber)
        return tryNumber.toInt()
    }

    private fun callException(): Nothing = throw IllegalArgumentException("잘못된 값을 입력하였습니다.")

    fun checkCarNameLength(racingcarName: String) {
        if (racingcarName.length > 5) callException()
    }

    fun checkTryNumber(tryNumber: String) {
        tryNumber.toIntOrNull() ?: callException()
    }

    private fun race(racingcarName: List<String>, tryNumber: Int) {
        outputView.printResult()
        var carScore = racingcarName.associateWith { 0 }.toMutableMap()

        for (i in 0 until tryNumber) {
            moveCar.calculateScore(carScore)
            outputView.printCarScore(carScore)
        }
        val winner = winner.calculateWinner(carScore)
        outputView.printWinner(winner)
    }
}