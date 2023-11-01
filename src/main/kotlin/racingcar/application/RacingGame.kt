package racingcar.application

import racingcar.domain.RacingCars
import racingcar.ui.DisplayBoard
import racingcar.ui.Player

class RacingGame {
    private val player = Player()
    private val displayBoard = DisplayBoard()

    fun start() {
        val (racingCars, tryCount) = initializeGame()

        runGame(racingCars, tryCount)

        finishGame(racingCars)
    }

    private fun initializeGame(): Pair<RacingCars, Int> {
        val racingCars = RacingCars.fromNames(player.inputCarNames())
        val tryCount = player.inputTryCount()
        return Pair(racingCars, tryCount)
    }

    private fun runGame(racingCars: RacingCars, tryCount: Int) {
        displayBoard.displayRaceStart()

        repeat(tryCount) {
            racingCars.move()
            displayBoard.displayRacingResults(racingCars)
        }
    }

    private fun finishGame(racingCars: RacingCars) {
        val winners = racingCars.findWinners()
        displayBoard.displayWinners(winners)
    }
}
