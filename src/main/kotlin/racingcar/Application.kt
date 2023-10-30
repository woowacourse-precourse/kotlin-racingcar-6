package racingcar

import racingcar.game.CarRacingGame
import racingcar.manager.OutputManager

fun main() {
    startRacingGame()
}

private fun startRacingGame() {
    val carRaceGame = CarRacingGame()
        .setUp()
        .race()
    with(OutputManager()) {
        racingRoundResult(carRaceGame.racingResult())
        winner(carRaceGame.winner())
    }
}

