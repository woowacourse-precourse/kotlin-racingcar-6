package race

import car.Car
import car.CarConfiguration.INIT_DIST
import race.RacingSystemValues.FINAL_WINNER
import race.RacingSystemValues.WINNER_SEPARATOR
import java.math.BigInteger

class Racing {
    private var firstCarDist = BigInteger(INIT_DIST)
    fun start(racingCarList: List<Car>): StringBuilder {
        val roundResult = StringBuilder()
        for (car in racingCarList) {
            car.start()
            roundResult.append(car.distInfo())
            if (car.nowDist() > firstCarDist) firstCarDist = car.nowDist()
        }
        return roundResult.appendLine()
    }

    fun findWinner(racingCarList: List<Car>): StringBuilder {
        val winnerList = racingCarList.filter { car ->
            car.nowDist() == firstCarDist
        }
        val raceResult = StringBuilder()
        raceResult.append(FINAL_WINNER)
        winnerList.forEachIndexed { index, car ->
            raceResult.append(car.carName())
            if (index != winnerList.lastIndex) raceResult.append(WINNER_SEPARATOR)
        }
        return raceResult
    }
}
