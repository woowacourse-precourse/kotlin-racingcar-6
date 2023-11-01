package racingcar

import racingcar.command.CommandInvoker
import racingcar.model.CarCollection
import racingcar.model.Round
import racingcar.view.InputView
import racingcar.view.OutputView

class CarRaceController {
    val inputView = InputView()
    val outputView = OutputView()
    lateinit var carCollection: CarCollection
    lateinit var round: Round

    fun doRace() {
        getCars()
        getRound()
        outputView.raceStart()
        for (i in 0..< round.getRound()) {
            CommandInvoker.executeCommands()
            outputView.printRound(carCollection.getCarsDto())
        }
        outputView.printWinner(carCollection.getWinnersDto())
        CommandInvoker.clearCommands()
    }

    fun getCars() {
        val inputString = inputView.inputCarNames()
        carCollection = CarCollection(inputString)
    }

    fun getRound() {
        val inputNumber = inputView.inputRoundNum()
        round = Round(inputNumber)
    }


}