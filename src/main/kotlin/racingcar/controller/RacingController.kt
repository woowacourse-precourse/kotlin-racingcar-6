package racingcar.controller

import racingcar.model.AttemptsNumber
import racingcar.model.Car
import racingcar.model.Cars
import racingcar.model.Racing
import racingcar.util.Constants
import racingcar.view.InputView
import racingcar.view.OutputView

class RacingController() {
    private var attemptsNum = 0
    private lateinit var carList: List<Car>
    private val inputView = InputView()
    private val outputView = OutputView()

    fun run() {
        printStartAndGetCarList()
        requestAttemptsNumber()
        doRacingAndPrintResult()
    }

    private fun doRacingAndPrintResult() {
        val racing = Racing(carList)
        repeat(attemptsNum) { racing.runRaceOnce().apply { outputView.printMatchProgress(carList) } }
        racing.getWinner()
        outputView.printWinner(racing.winner)
    }

    private fun requestAttemptsNumber() {
        outputView.requestAttemptsNumber(Constants.NUMBER_ATTEMPTS_MSG)
        val attemptsNumber = AttemptsNumber(inputView.getAttemptsNumber())
        attemptsNum = attemptsNumber.validAttemptsNum
    }

    private fun printStartAndGetCarList() {
        outputView.printRaceStart(Constants.RACE_START_MSG)
        val cars = Cars(inputView.getCarList())
        carList = cars.carList
    }
}