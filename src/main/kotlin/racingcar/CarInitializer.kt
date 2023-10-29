package racingcar

import model.CarModel

class CarInitializer {
    companion object {
        fun initializeCars(cars: List<String>): List<CarModel> {
            return cars.map { CarModel(it, 0) }
        }
    }
}