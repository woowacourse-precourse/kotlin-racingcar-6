package racingcar.model

import racingcar.SEPARATOR
import racingcar.command.CommandInvoker
import racingcar.command.DoRaceCommand

class CarCollection(carNameString: String) {
    private var cars : List<Car>

    init {
        val carNames = carNameString.split(SEPARATOR)
        val inputCars = carNames
            .map {
                Car(Name(it), Position())
            }
            .toMutableList()
        cars = inputCars
        putCarCommands()
    }

    private fun putCarCommands() {
        for (car in cars) {
            CommandInvoker.addCommand(DoRaceCommand(car))
        }
    }

    fun getWinners(): MutableList<Car> {
        val maxPositionCar = cars.stream().max(Car::compareTo).orElse(null)
        val winnerList = mutableListOf<Car>()

        for (car in cars) {
            if (car.equals(maxPositionCar)) {
                winnerList.add(car)
            }
        }
        return winnerList
    }

    operator fun get(index: Int): Car? {
        return cars.getOrNull(index)
    }
}