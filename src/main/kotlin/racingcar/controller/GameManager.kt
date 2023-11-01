package racingcar.controller

import camp.nextstep.edu.missionutils.Console
import racingcar.model.*
import racingcar.view.InputView
import racingcar.view.OutputView

class GameManager {
    fun start() {
        val carNamesSeparated = carNameinput()
        val tryNum = tryNumberInput()
        validate(carNamesSeparated, tryNum)
        val carProgress = racing(carNamesSeparated, tryNum.toInt())
        winnerOutput(carNamesSeparated, carProgress)
        Console.close()
    }

    fun validate(carNamesSeparated: List<String>, tryNum: String) {
        Validation().carName(carNamesSeparated)
        Validation().tryNum(tryNum)
    }

    fun carNameinput(): List<String> {
        OutputView().carInputMassage()
        val carNames = InputView().Input()
        return CarNameSeparator().separator(carNames)
    }

    fun tryNumberInput(): String {
        OutputView().tryInputMassage()
        return InputView().Input()
    }

    fun racing(carNamesSeparated: List<String>, tryNum: Int): List<String> {
        OutputView().racingResult()
        var carProgress: List<String> = CarProgressInit().progress(carNamesSeparated.size)
        for (i in 0..<tryNum) {
            carProgress = RacingGame().racing(carProgress)
            OutputView().eachRacingResult(carNamesSeparated, carProgress)
        }
        return carProgress
    }

    fun winnerOutput(carNamesSeparated: List<String>, carProgress: List<String>) {
        val winners = WinnerDiscrimination().answer(carProgress, carNamesSeparated)
        OutputView().winner(winners)
    }
}