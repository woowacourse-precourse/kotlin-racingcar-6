package racingcar.domain

import racingcar.validator.CarNameValidator
import racingcar.view.InputView

class RacingCarGame {
    private val inputView = InputView()
    private val carNameValidator = CarNameValidator()

    fun startGame() {
        val carName = getCarNames()
    }

    private fun getCarNames():String {
        val carName = inputView.getCarNameFromUser()
        carNameValidator.validate(carName)

        return carName
    }
}