package racingcar.game

import camp.nextstep.edu.missionutils.Randoms

object RacingGame {

    private const val RANDOM_MIN_NUM = 0
    private const val RANDOM_MAX_NUM = 9
    private const val MIN_NUM_TO_FORWARD = 4

    fun moveCarsRandomly(cars: List<Car>) {
        cars.forEach {
            if (isCarMovable()) it.position++
        }
    }

    private fun isCarMovable(): Boolean =
        Randoms.pickNumberInRange(RANDOM_MIN_NUM, RANDOM_MAX_NUM) >= MIN_NUM_TO_FORWARD

    fun chooseWinners(cars: List<Car>): List<Car> {
        val maxPosition = cars.maxOf { it.position }
        return cars.filter { it.position == maxPosition }
    }
}