package racingcar.domain

import racingcar.validator.CarNameValidator
import racingcar.validator.MoveCountValidator
import racingcar.view.InputView

class RacingCarGame {
    private val inputView = InputView()
    private val carNameValidator = CarNameValidator()
    private val moveCountValidator = MoveCountValidator()

    fun startGame() {
        val carName = getCarNames()
        val moveCount = getMoveCount().toInt()
        val race = Race(carName, moveCount)

        race.startRace()
    }

    private fun getCarNames():String {
        val carName = inputView.getCarNameFromUser()
        carNameValidator.validate(carName)

        return carName
    }

    private fun getMoveCount(): String {
        val moveCount = inputView.getMoveCountFromUser()
        moveCountValidator.validate(moveCount)

        return moveCount
    }
}