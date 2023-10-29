package racingcar

import racingcar.game.CarRacingGame

fun main() {
    val carRaceGame = CarRacingGame()
        .setUp()
        .race()

    val raceResult = carRaceGame.racingResult()
    val winner = carRaceGame.winner(raceResult)
}

