package racingcar.domain

import racingcar.validator.CarNameValidator
import racingcar.validator.MoveCountValidator
import racingcar.InputManager
import racingcar.OutputManager

class RacingCarGame {
    private val inputManager = InputManager()
    private val outputManager = OutputManager()
    private val carNameValidator = CarNameValidator()
    private val moveCountValidator = MoveCountValidator()

    private lateinit var carNames: String
    private lateinit var circuit: Circuit

    fun startGame() {
        initGame()
        processGame()
        displayGameOutcome()
    }

    private fun initGame() {
        carNames = getValidatedCarNames()
        val moveCount = getValidatedMoveCount().toInt()
        circuit = Circuit(carNames, moveCount)
    }

    private fun processGame() {
        outputManager.printRaceStartResult()
        circuit.startRace()
    }

    private fun displayGameOutcome() {
        val referee = Referee(circuit.getCarList())
        val winnerCarNames = referee.getWinningCarNames()
        outputManager.printWinners(winnerCarNames)
    }

    private fun getValidatedCarNames(): String {
        val names = inputManager.getCarNameFromUser()
        carNameValidator.validate(names)

        return names
    }

    private fun getValidatedMoveCount(): String {
        val count = inputManager.getMoveCountFromUser()
        moveCountValidator.validate(count)

        return count
    }
}