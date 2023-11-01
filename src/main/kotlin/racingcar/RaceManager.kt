package racingcar

import camp.nextstep.edu.missionutils.Randoms

class RaceManager {
    private lateinit var cars: List<Car>

    fun setup(cars: List<Car>) {
        this.cars = cars
    }

    fun race(): List<Car> {
        for (car in cars) {
            moveIfPossible(car)
        }
        return cars
    }

    private fun moveIfPossible(car: Car) {
        if (Randoms.pickNumberInRange(RANDOM_START_NUMBER, RANDOM_END_NUMBER) >= MOVE_MIN_NUMBER) {
            car.move()
        }
    }

    fun findWinners(): List<Car> {
        val maxPosition = cars.maxOf { it.position }
        return cars.filter { it.position == maxPosition }
    }

    companion object {
        private const val RANDOM_START_NUMBER = 0
        private const val RANDOM_END_NUMBER = 9
        private const val MOVE_MIN_NUMBER = 4
    }
}
