package racingcar.domain

import racingcar.InputManager
import racingcar.OutputManager
import racingcar.validator.CarNameValidator
import racingcar.validator.RaceRoundValidator

class RacingCarGame {
    private val inputManager = InputManager()
    private val outputManager = OutputManager()
    private val carNameValidator = CarNameValidator()
    private val raceRoundValidator = RaceRoundValidator()
    private lateinit var circuit: Circuit

    fun startGame() {
        init()
        process()
        displayResult()
    }

    private fun init() {
        val carNames = getValidatedCarNames()
        val raceRound = getValidatedRaceRound()
        circuit = Circuit(carNames, raceRound)
    }

    private fun process() {
        outputManager.printRaceStartMessage()
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

    private fun getValidatedRaceRound(): Int {
        val raceRound = inputManager.getRaceRoundFromUser()
        raceRoundValidator.validate(raceRound)
        return raceRound.toInt()
    }
}