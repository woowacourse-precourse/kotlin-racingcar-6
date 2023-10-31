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
        init()
        process()
        displayResult()
    }

    private fun init() {
        carNames = getValidatedCarNames()
        val moveCount = getValidatedMoveCount().toInt()
        circuit = Circuit(carNames, moveCount)
    }

    private fun process() {
        outputManager.printRaceStartResult()
        circuit.startRace()
    }

    private fun displayResult() {
        val referee = Referee(circuit.getCarList())
        val winningCarNames = referee.getWinningCarNames()
        outputManager.printWinners(winningCarNames)
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