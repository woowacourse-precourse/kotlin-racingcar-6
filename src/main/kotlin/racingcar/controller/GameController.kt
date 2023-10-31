package racingcar.controller

import racingcar.model.Car
import racingcar.model.Cars
import racingcar.model.Repetition
import racingcar.model.Winner
import racingcar.utils.Round
import racingcar.view.InputView
import racingcar.view.OutputView

class GameController {
    private val inputView: InputView = InputView()
    private val outputView: OutputView = OutputView()

    fun start() {
        val carNameList = inputCarName()
        val cars = Cars.fromNames(carNameList)

        val repetitionInput = inputRepetition()
        val repetition = Repetition(repetitionInput)

        playRounds(repetition.count, cars.carList)
        playResult(cars.carList)
    }

    fun inputCarName(): List<String> {
        val carNameInput = inputView.promptCarNames()
        return inputView.splitCarNamesByComma(carNameInput)
    }

    fun inputRepetition() = inputView.promptRepetition()

    fun playRounds(count: Int, carList: List<Car>) {
        outputView.printResultInfo()

        repeat(count) {
            advanceCarsInRound(carList)
            outputView.printRoundResult(carList)
        }
    }

    private fun advanceCarsInRound(carList: List<Car>) {
        for (currentCar in carList) {
            val generatedNumber = Round.generateRandomNumber()
            val canMoveForward = Round.isForward(generatedNumber)
            if (canMoveForward) {
                currentCar.moveForward()
            }
        }
    }

    private fun playResult(carList: List<Car>) {
        val winner = Winner(carList)
        outputView.printWinner(winner.winnerList)
    }
}