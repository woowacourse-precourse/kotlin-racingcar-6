package racingcar.controller

import racingcar.model.CarModel
import racingcar.view.InputView
import camp.nextstep.edu.missionutils.Console
import racingcar.util.COMMA
import racingcar.view.OutputView


class RacingCarController {
    private val model = CarModel()
    private val inputView = InputView()
    private val outputView = OutputView()

    fun startRacingCarGame() {
        val carNames = inputCarNames()
        model.setCarNames(carNames)

        val attemptsNumber = inputAttemptsNumber()
        model.setAttemptsNumber(attemptsNumber)

        model.initProgressList()
        outputView.printExecutionResult()

        for (i in 1..attemptsNumber) {
            model.moveCar()
            printEachRacingCar(carNames)
        }

        val winners = calculateWinners(carNames)
        printRacingCarWinner(winners)
    }

    private fun inputCarNames(): List<String> {
        inputView.inputCarNames()
        val input = Console.readLine()
        return input.split(COMMA)
    }

    private fun inputAttemptsNumber(): Int {
        inputView.inputAttemptsNumber()
        val attemptsNumber = Console.readLine()
        return attemptsNumber.toInt()
    }

    private fun printEachRacingCar(carNames: List<String>) {
        for (i in carNames.indices) {
            val progress = model.getCarProgress(i)
            outputView.printRoundResult(carNames[i])
            outputView.makeDash((progress))
        }
        println()
    }

    private fun calculateWinners(carNames: List<String>): List<String> {
        val maxProgress = model.getMaxProgress()
        return carNames.filterIndexed { index, _ -> model.getCarProgress(index) == maxProgress }
    }

    private fun printRacingCarWinner(winners: List<String>) {
        outputView.printWinners(winners)
    }
}