package race

import car.Car
import car.CarFactory.makeCar

class Racing {
    private var racingCarList = mutableListOf<Car>()
    fun settingRacingCar(carList: List<String>) {
        carList.forEach {
            racingCarList.add(makeCar(it))
        }
    }
}