package racingcar.controller

import racingcar.model.*
import racingcar.view.InputView
import racingcar.view.OutputView

class GameManager {
    fun start() {
        val carNamesSeparated = carNameinput()
        val tryNum = tryNumberInput()
        val carProgress = racing(carNamesSeparated,tryNum)
        winnerOutput(carNamesSeparated,carProgress)
    }

    fun carNameinput():List<String>{
        OutputView().carInputMassage()
        val carNames = InputView().carNameInput()
        val carNamesSeparated = CarNameSeparator().separator(carNames)
        Validation().carName(carNamesSeparated)
        return carNamesSeparated
    }

    fun tryNumberInput():Int{
        OutputView().tryInputMassage()
        val tryNum = InputView().tryNameInput() // 시도 횟수 입력
        val num = Validation().tryNum(tryNum)
        return num
    }

    fun racing(carNamesSeparated:List<String>,tryNum:Int):List<String>{
        OutputView().racingResult()
        var carProgress: List<String> = CarProgressInit().progress(carNamesSeparated.size)
        for (i in 0..<tryNum) {
            carProgress = RacingGame().racing(carProgress)
            OutputView().eachRacingResult(carNamesSeparated, carProgress)
        }
        return carProgress
    }

    fun winnerOutput(carNamesSeparated:List<String>,carProgress:List<String>){
        val winners = WinnerDiscrimination().answer(carProgress, carNamesSeparated)
        OutputView().winner(winners)
    }
}