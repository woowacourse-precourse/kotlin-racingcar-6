package racingcar

import racingcar.game.CarRacingGame

fun main() {
    startRacingGame()
}

private fun startRacingGame() {
    CarRacingGame().apply {
        val carRaceGame = setUp().race()
        outputManager.racingRoundResult(carRaceGame.racingResult())
        outputManager.winner(carRaceGame.winner())
    }
}

