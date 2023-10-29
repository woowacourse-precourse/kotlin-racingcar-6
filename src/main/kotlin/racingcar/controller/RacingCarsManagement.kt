package racingcar.controller

import racingcar.model.RacingCarModel

class RacingCarsManagement(private val cars:MutableList<RacingCarModel>) {

    fun addRacingCar(racingCarModel: RacingCarModel){
        cars.add(racingCarModel)
    }

    fun getWinners():List<RacingCarModel>{
        val maxPlace = cars.maxOf { it.place }
        return cars.filter { car -> car.place == maxPlace}
    }

}