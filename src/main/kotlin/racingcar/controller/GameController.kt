package racingcar.controller

import camp.nextstep.edu.missionutils.Randoms
import racingcar.model.Car
import racingcar.model.Cars
import racingcar.model.Winners
import racingcar.view.ScreenView


class GameController (private val view: ScreenView){
    fun goOrNot(car: Car){
        val randomNumber = Randoms.pickNumberInRange(0, 9)
        if (randomNumber >= 4) { car.moved() }
    }

    fun inputCars(): Cars {
        val userCar = view.inputCarName()
        val cars = Cars()

        for (carName in userCar) {
            val car = Car(name = carName)
            cars.add(car)
        }
        return cars
    }

    fun getWinners(cars: MutableList<Car>): Winners? {
        val maxDistance = cars.maxByOrNull { it.distance }?.distance
        if (maxDistance != null) {
            val winners = Winners(mutableListOf())
            cars.forEach { car ->
                if (car.distance == maxDistance) { winners.winners.add(car) }
            }
            return winners
        }
        return null
    }
}