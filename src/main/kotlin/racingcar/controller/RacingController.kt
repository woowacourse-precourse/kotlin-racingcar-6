package racingcar.controller

import racingcar.model.Car
import racingcar.model.CarName
import racingcar.model.Cars
import racingcar.model.Round
import racingcar.view.InputView
import racingcar.view.OutputView

class RacingController(
    private val inputView: InputView = InputView(),
    private val outputView: OutputView = OutputView()
) {

    fun startRace() {
        initializeRace()
    }

    private fun inputCarName(): List<CarName> {
        outputView.printInputName()
        return inputView.inputCarName()
    }

    private fun inputRound(): Round {
        outputView.printInputRound()
        return inputView.inputRound()
    }

    private fun initializeRace() {
        val cars = mutableListOf<Car>()
        inputCarName().forEach {
            // 원시값 포장을 풀어서 Model에 전달
            cars.add(Car(it.name))
        }
        runRace(Cars(cars))
    }

    private fun runRace(cars: Cars) {
        val round = inputRound().value
        outputView.printResultMessage()
        repeat(round) {
            cars.raceCars()
            outputView.printRacing(cars)
        }
        val winner = cars.getWinners()
        printWinner(winner)
    }

    private fun printWinner(winners: List<Car>) {
        outputView.printWinners(winners)
    }
}