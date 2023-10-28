package racingcar.view_model

import racingcar.model.CarNameSeparator
import racingcar.model.Constants
import racingcar.model.RacingGame
import racingcar.model.Validation
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
        for (i in 0..Num){
            RacingGame().racing(carNamesSeparated)
        }
    }
}