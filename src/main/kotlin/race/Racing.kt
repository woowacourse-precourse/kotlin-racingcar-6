package race

import car.Car
import car.CarConfiguration.INIT_DIST
import car.CarFactory.makeCar
import race.RacingSystemValues.FINAL_WINNER
import race.RacingSystemValues.WINNER_SEPARATOR
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

    fun printWinner() {
        val winnerList = racingCarList.filter { it.nowDist() == firstCarDist }
        print(FINAL_WINNER)
        winnerList.forEachIndexed { index, car ->
            car.printCarName()
            if (index != winnerList.lastIndex) {
                print(WINNER_SEPARATOR)
            }
        }
    }
}
