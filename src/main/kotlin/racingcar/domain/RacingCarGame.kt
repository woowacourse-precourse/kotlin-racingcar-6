package racingcar.domain

import racingcar.validator.CarNameValidator
import racingcar.validator.MoveCountValidator
import racingcar.utils.InputManager
import racingcar.utils.OutputManager

class RacingCarGame {
    private val inputManager = InputManager()
    private val outputManager = OutputManager()
    private val carNameValidator = CarNameValidator()
    private val moveCountValidator = MoveCountValidator()

    private lateinit var carName: String
    private lateinit var circuit: Circuit

    fun startGame() {
        initGame()
        processGame()
        displayGameOutcome()
    }

    private fun initGame() {
        carName = getValidatedCarNames()
        val moveCount = getValidatedMoveCount().toInt()
        circuit = Circuit(carName, moveCount)
    }

    private fun processGame() {
        outputManager.printRaceResult()
        circuit.startRace()
    }

    private fun displayGameOutcome() {
        val referee = Referee(circuit)
        val winnerCarNames = referee.getWinnerCarNames()
        outputManager.printWinners(winnerCarNames)
    }

    private fun getValidatedCarNames(): String {
        val carName = inputManager.getCarNameFromUser()
        carNameValidator.validate(carName)

        return carName
    }

    private fun getValidatedMoveCount(): String {
        val moveCount = inputManager.getMoveCountFromUser()
        moveCountValidator.validate(moveCount)

        return moveCount
    }
}