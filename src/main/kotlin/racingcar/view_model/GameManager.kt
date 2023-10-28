package racingcar.view_model

import racingcar.model.*
import racingcar.view.InputView
import racingcar.view.OutputView

class GameManager {
    fun start() {
        OutputView().carInputMassage()
        val carNames = InputView().carNameInput()
        val carNamesSeparated = CarNameSeparator().separator(carNames)
        OutputView().tryInputMassage()
        val tryNum = InputView().tryNameInput()
        val Num = Validation().tryNum(tryNum)
        var carProgress :MutableList<Int> = CarProgressInit().progress(carNamesSeparated.size)
        OutputView().racingResult()
        for (i in 0..Num-1){
            carProgress = RacingGame().racing(carProgress)
            OutputView().eachRacingResult(carNamesSeparated,carProgress)
        }
    }
}