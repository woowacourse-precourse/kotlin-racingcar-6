package racingcar.controller

import racingcar.model.RacingCarGenerator
import racingcar.model.RacingCarModel

class RacingCarsDTO(val carsName: String) {

    init {
        carsName.split(",").forEach { carName -> require(carName.length <= 5) }
    }

    fun convertRacingCars() = carsName.split(",").map { carName -> RacingCarModel(carName) }.toMutableList()

}