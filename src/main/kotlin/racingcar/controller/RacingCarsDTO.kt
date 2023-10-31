package racingcar.controller

import racingcar.model.RacingCarGenerator
import racingcar.model.RacingCarModel

class RacingCarsDTO(val carsName:String) {
    fun convertRacingCars() = carsName.split(" ").map {carName -> RacingCarModel(carName) }

}