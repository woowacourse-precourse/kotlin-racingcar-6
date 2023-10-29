package racingcar.domain

import racingcar.validator.CarNameValidator
import racingcar.validator.MoveCountValidator
import racingcar.utils.InputManager

class RacingCarGame {
    private val inputManager = InputManager()
    private val carNameValidator = CarNameValidator()
    private val moveCountValidator = MoveCountValidator()

    fun startGame() {
        val carName = getCarNames()
        val moveCount = getMoveCount().toInt()
        val race = Race(carName, moveCount)

        race.startRace()
    }

    private fun getCarNames():String {
        val carName = inputManager.getCarNameFromUser()
        carNameValidator.validate(carName)

        return carName
    }

    private fun getMoveCount(): String {
        val moveCount = inputManager.getMoveCountFromUser()
        moveCountValidator.validate(moveCount)

        return moveCount
    }
}