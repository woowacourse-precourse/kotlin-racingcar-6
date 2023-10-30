package racingcar

import racingcar.game.CarRacingGame

fun main() {
    startRacingGame()
}

private fun startRacingGame() {
    val carRaceGame = CarRacingGame()
        .setUp().race()
//        printRaceResult()
//        printWinner()



    val raceResult = carRaceGame.racingResult()
    println(raceResult)
}

