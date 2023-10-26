package racingcar.game

import racingcar.game.PrintUtil.printAskAttempts
import racingcar.game.PrintUtil.printExecutionResult
import racingcar.game.PrintUtil.printStartMessage
import racingcar.game.PrintUtil.printRacingCars
import racingcar.game.PrintUtil.printWinnerList

class RacingGame {
    private lateinit var racingCars: List<Car>

    fun start() {
        printStartMessage()
        inviteRacer()
        printAskAttempts()
        processRacingGame()
        startAwardCeremony()
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

    private fun startAwardCeremony() {
        val winnerList = rateAllRacers()
        // TODO : PrintUtil.printWinner 메서드 구현
        printWinnerList(winnerList)
    }

    private fun rateAllRacers(): MutableList<Car> {
        val winners = mutableListOf<Car>()
        val maxDistance = -1
        racingCars.sortedBy { _car -> _car.getDistance() }.forEach { _car ->
            if (_car.getDistance() >= maxDistance) {
                winners.add(_car)
            }
        }
        return winners
    }
}