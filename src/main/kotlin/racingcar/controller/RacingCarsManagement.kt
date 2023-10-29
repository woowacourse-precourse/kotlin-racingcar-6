package racingcar.controller

import racingcar.model.RacingCarModel

class RacingCarsManagement(private val cars:MutableList<RacingCarModel>) {

    fun addRacingCar(racingCarModel: RacingCarModel){
        cars.add(racingCarModel)
    }

}