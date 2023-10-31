package racingcar.controller

import racingcar.model.car.Car
import racingcar.model.car.CarFactory
import racingcar.model.car.CarName
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
        raceView.displayRaceResultTitle()

        repeat(turnNumber.number) {
            raceOnce(cars = cars)
            raceView.displayRaceResult(cars = cars)
        }

        val winnerNames = getWinnerNames(cars = cars)
        raceView.displayWinners(winnerNames = winnerNames)
    }

    private fun raceOnce(cars: List<Car>) {
        cars.forEach { car -> car.tryGoForward() }
    }

    private fun getWinnerNames(cars: List<Car>): List<CarName> {
        if (cars.isEmpty()) return emptyList()

        val maxDistance = cars.maxOf { it.distance }
        return cars.filter { it.distance == maxDistance }.map { it.name }
    }
}