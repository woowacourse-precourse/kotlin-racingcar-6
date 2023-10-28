package racingcar.controller

import racingcar.model.CarName
import racingcar.view.InputView
import racingcar.view.OutputView

class RacingController(
    private val inputView: InputView = InputView(),
    private val outputView: OutputView = OutputView()
) {

    fun inputCarName(): List<CarName> {
        outputView.printInputName()
        return inputView.inputCarName()
    }

}