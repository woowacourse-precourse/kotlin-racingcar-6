package racingcar

import utils.Constants.FORWARD_STEP
import utils.RandomNumGenerator

class Race(private val carList: List<Car>) {
    fun startRound(): List<Car> {
        carList.forEach { car ->
            if (RandomNumGenerator.getRandomNum() > 3) {
                car.goForward(FORWARD_STEP)
            }
        }
        return carList
    }

    fun findWinner(): List<Car> {
        val maxDistance = carList.maxOfOrNull { it.distance }
        return carList.filter { car ->
            car.distance == maxDistance
        }
    }
}