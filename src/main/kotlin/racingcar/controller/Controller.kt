package racingcar.controller

import racingcar.validator.Validator
import racingcar.view.OutputView

class Controller(
    private val validator: Validator,
) {
    fun startGame() {
        OutputView.enterNamesOfCars()
    }
}
