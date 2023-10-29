package race

import car.Car
import car.CarConfiguration.INIT_DIST
import car.CarFactory.makeCar
import java.math.BigInteger

class Racing {
    private var racingCarList = listOf<Car>()
    private var firstCarDist = BigInteger(INIT_DIST)
    fun settingRacingCar(carList: List<String>) {
        val tempCarList = mutableListOf<Car>()
        carList.forEach {
            tempCarList.add(makeCar(it))
        }
        racingCarList = tempCarList
    }

    fun start() {
        for (car in racingCarList) {
            car.start()
            car.printDist()
            if (car.nowDist() > firstCarDist) {
                firstCarDist = car.nowDist()
            }
        }
        println()
    }
}
