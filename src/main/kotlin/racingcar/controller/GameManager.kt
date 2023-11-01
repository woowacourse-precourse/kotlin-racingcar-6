package racingcar.controller

import camp.nextstep.edu.missionutils.Console
import racingcar.model.*
import racingcar.view.InputView
import racingcar.view.OutputView

class GameManager {
    fun start() {
        val carNamesSeparated = carNameinput()
        val tryNum= tryNumberInput()
        validate(carNamesSeparated,tryNum.toString())
        val carProgress = racing(carNamesSeparated, tryNum)
        winnerOutput(carNamesSeparated, carProgress)
        Console.close()
    }
    fun validate(carNamesSeparated: List<String>, tryNum:String){
        Validation().carName(carNamesSeparated)
        Validation().tryNum(tryNum)
    }
    fun carNameinput(): List<String> {
        OutputView().carInputMassage()
        val carNames = InputView().Input()
        val carNamesSeparated = CarNameSeparator().separator(carNames)
        return carNamesSeparated
    }

    fun tryNumberInput(): Int {
        OutputView().tryInputMassage()
        val tryNum = InputView().Input() // 시도 횟수 입력
        return tryNum.toInt()
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