package racingcar.controller

import racingcar.model.RacingCarModel

class RacingCarsManagement(val cars:MutableList<RacingCarModel>) {

    fun addRacingCar(racingCarModel: RacingCarModel){
        cars.add(racingCarModel)
    }

    fun getWinners():String{
        val maxPlace = cars.maxOf { it.place }
        return "${cars.filter { car -> car.place == maxPlace}.map { racingCarModel ->racingCarModel.name  }.joinToString(", ")}"
    }

}