package racingcar

import race.RacingManager

fun main() {
    val racingManager = RacingManager()
    racingManager.settingRacingCar()
    racingManager.raceStart()
    racingManager.printWinner()
}
