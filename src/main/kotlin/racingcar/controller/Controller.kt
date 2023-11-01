package racingcar.controller

import racingcar.validator.Validator
import racingcar.view.InputView
import racingcar.view.OutputView

class Controller(
    private val validator: Validator,
) {
    fun startGame() {
        OutputView.enterNamesOfCars()
    }

    private fun getNamesOfCar(): List<String> {
        return InputView.askCarToRace(validator)
    }
}
