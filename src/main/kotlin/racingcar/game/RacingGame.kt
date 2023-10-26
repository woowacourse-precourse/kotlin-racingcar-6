package racingcar.game

import racingcar.game.PrintUtil.printAskAttempts
import racingcar.game.PrintUtil.printExecutionResult
import racingcar.game.PrintUtil.printStartMessage
import racingcar.game.PrintUtil.printRacingCars

class RacingGame {
    private lateinit var racingCars: List<Car>

    fun start() {
        printStartMessage()
        inviteRacer()
        printAskAttempts()
        processRacingGame()
    }

    private fun inviteRacer() {
        racingCars = UserInput.getRacingCars()
    }

    private fun processRacingGame() {
        val attempts = UserInput.getAttempts()
        printExecutionResult()
        repeat(attempts) {
            processRacingCars()
            printRacingCars(racingCars)
        }
    }

    private fun processRacingCars() {
        racingCars.map { _car ->
            with(_car) {
                startEngine()
                this
            }
        }
    }
}