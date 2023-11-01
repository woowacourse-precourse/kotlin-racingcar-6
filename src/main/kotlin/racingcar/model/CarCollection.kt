package racingcar.model

import racingcar.command.CommandInvoker
import racingcar.command.DoRaceCommand
import racingcar.dto.CarDto
import racingcar.dto.WinnerDto


class CarCollection(carNameString: String) {
    private var cars : List<Car>

    init {
        val carNames = carNameString.split(",")
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
        val maxPositionCar = cars.max()
        val winnerList = mutableListOf<Car>()

        for (car in cars) {
            if (car == maxPositionCar) {
                winnerList.add(car)
            }
        }
        return winnerList
    }

    operator fun get(index: Int): Car? {
        return cars.getOrNull(index)
    }

    fun getCarsDto(): MutableList<CarDto> {
        val carDtoList : MutableList<CarDto> = mutableListOf<CarDto>()

        cars.forEach{ car: Car ->
            carDtoList.add(CarDto(car.getCarNameString(), car.getPositionNumber()))
        }
        return carDtoList
    }

    fun getWinnersDto(): MutableList<WinnerDto> {
        val winnerDtoList : MutableList<WinnerDto> = mutableListOf<WinnerDto>()

        cars.forEach{ car: Car ->
            winnerDtoList.add(WinnerDto(car.getCarNameString()))
        }

        return winnerDtoList
    }
}