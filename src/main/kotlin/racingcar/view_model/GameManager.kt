package racingcar.view_model

import racingcar.model.Constants
import racingcar.view.InputView
import racingcar.view.OutputView

class GameManager {
    fun start(){
        OutputView().carInputMassage()
        val carNames = InputView().carNameInput()

    }
}