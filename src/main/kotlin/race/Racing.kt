package race

import car.Car
import car.CarFactory.makeCar

class Racing {
    private var racingCarList = listOf<Car>()
    fun settingRacingCar(carList: List<String>) {
        val tempCarList = mutableListOf<Car>()
        carList.forEach {
            tempCarList.add(makeCar(it))
        }
        racingCarList = tempCarList
    }
}