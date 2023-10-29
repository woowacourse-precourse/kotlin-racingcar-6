package race

import car.Car
import car.CarFactory.makeCar
import race.RacingSystemValues.INIT_RACING_ROUND
import java.math.BigInteger

class Racing {
    private var racingCarList = listOf<Car>()
    private var racingRound = BigInteger(INIT_RACING_ROUND)

    fun settingRacingCar(carList: List<String>) {
        val tempCarList = mutableListOf<Car>()
        carList.forEach {
            tempCarList.add(makeCar(it))
        }
        racingCarList = tempCarList
    }

    fun settingRacingRound(round: BigInteger) {
        racingRound = round
    }
}
