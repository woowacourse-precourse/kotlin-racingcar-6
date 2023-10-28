package racingcar

import racingcar.raceModel.Race

class RaceController(private val race: Race, private val view: RaceView) {

    fun startRace(time: Int) {
        repeat(time) {
            race.run()
            view.showCars(race.cars)
            println()
        }
        view.showWinners(race.getWinners())
    }
}
