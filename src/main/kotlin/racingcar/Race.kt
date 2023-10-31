package racingcar

import utils.Constants.FORWARD_STEP
import utils.RandomNumGenerator

class Race(val carList: List<Car>, val roundCnt: Int) {

    fun startRound() {
        carList.forEach { car ->
            if (RandomNumGenerator.getRandomNum() > 3) {
                car.goForward(FORWARD_STEP)
            }
        }
    }
}