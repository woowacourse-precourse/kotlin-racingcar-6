package race

import car.CarConfiguration.INIT_DIST
import race.RacingSystemValues.FINAL_WINNER
import race.RacingSystemValues.WINNER_SEPARATOR
import java.math.BigInteger

class Racing {
    private var firstCarDist = BigInteger(INIT_DIST)
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
        val winnerList = racingCarList.filter { car ->
            car.nowDist() == firstCarDist
        }
        print(FINAL_WINNER)
        winnerList.forEachIndexed { index, car ->
            car.printCarName()
            if (index != winnerList.lastIndex) {
                print(WINNER_SEPARATOR)
            }
        }
    }
}
