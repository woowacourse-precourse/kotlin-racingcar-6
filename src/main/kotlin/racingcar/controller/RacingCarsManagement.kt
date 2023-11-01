package racingcar.controller

import racingcar.model.RacingCarModel

class RacingCarsManagement(val cars:MutableList<RacingCarModel>) {

    fun addRacingCar(racingCarModel: RacingCarModel){
        cars.add(racingCarModel)
    }

    fun getWinners():String{
        val maxPlace = cars.maxOf { it.place }

        return "최종 우승 : ${cars.filter { car -> car.place == maxPlace}.joinToString(", ")}"
    }

}