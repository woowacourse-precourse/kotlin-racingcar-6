package racingcar

import racingcar.command.CommandInvoker
import racingcar.model.CarCollection
import racingcar.model.Round
import racingcar.service.CarCollectionService
import racingcar.view.InputView
import racingcar.view.OutputView

class CarRaceController {
    val inputView = InputView()
    val outputView = OutputView()
    lateinit var carCollectionService: CarCollectionService
    lateinit var round: Round

    fun doRace() {
        getCars()
        getRound()
        raceStart()
        printWinner()
        CommandInvoker.clearCommands()
    }

    private fun getCars() {
        val inputString = inputView.inputCarNames()
        carCollectionService = CarCollectionService(inputString)
    }

    private fun getRound() {
        val inputNumber = inputView.inputRoundNum()
        round = Round(inputNumber)
    }

    private fun raceStart() {
        outputView.raceStart()
        for (i in 0..< round.getRound()) {
            CommandInvoker.executeCommands()
            outputView.printRound(carCollectionService.getCarsDto())
        }
    }

    private fun printWinner() {
        outputView.printWinner(carCollectionService.getWinnersDto())
    }
}