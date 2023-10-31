package racingcar

import utils.Constants
import utils.Constants.FORWARD_STEP
import utils.Constants.ROUND_RESULT_MSG
import utils.Constants.WINNER_RESULT_TITLE
import utils.RandomNumGenerator

class Race(private val carList: List<Car>, private val roundCnt: Int) {
    fun startRace() {
        println()
        println(Constants.ROUND_RESULT_MSG)
        for (cnt in 0 until roundCnt) {
            startRound()
            carList.forEach { car -> println(car) }
            println()
        }
    }

    private fun startRound() {
        carList.forEach { car ->
            if (RandomNumGenerator.getRandomNum() > 3) {
                car.goForward(FORWARD_STEP)
            }
        }
    }

    fun findWinner(): List<Car> {
        val maxDistance = carList.maxOfOrNull { it.distance }
        return carList.filter { car ->
            car.distance == maxDistance
        }
    }

    fun printWinner(winnerList: List<Car>) {
        print(WINNER_RESULT_TITLE)
        print(winnerList.joinToString(", ") { it.name })
    }
}