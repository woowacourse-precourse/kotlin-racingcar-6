package racingcar.controller

import racingcar.model.car.CarFactory
import racingcar.view.RaceView


class RaceController(
    private val raceView: RaceView,
    private val carFactory: CarFactory
) {
    fun startRace() {
        raceView.displayEnterCarNames()
        val carNames = raceView.getCarNamesFromUser()

        raceView.displayEnterTurnNumber()
        val turnNumber = raceView.getTurnNumberFromUser()

        val cars = carNames.map(carFactory::create)
    }
}