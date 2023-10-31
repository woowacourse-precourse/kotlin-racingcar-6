package racingcar.controller

import racingcar.model.RacingGameModel
import racingcar.view.ConsoleView

object RacingGameController {
    fun startGame() {
        val carNames = ConsoleView.inputCarNames()
        val tryCount = ConsoleView.inputTryCount()

        val racingGame = RacingGameModel.RacingGame(carNames, tryCount)

        for (round in 1..tryCount) {
            ConsoleView.printRound(round)
            racingGame.playRound()
            val results = racingGame.getResults()
            ConsoleView.printDistances(results)
        }

        val winners = getWinners(racingGame.getResults())
        ConsoleView.printWinner(winners)
    }

    fun getWinners(results: Map<String, Int>): Set<String> {
        val maxDistance = results.values.maxOrNull()
        return results.filterValues { it == maxDistance }.keys
    }
}
