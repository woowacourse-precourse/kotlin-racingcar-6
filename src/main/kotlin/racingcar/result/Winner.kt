package racingcar.result

import racingcar.car.Car

class Winner(private val cars: List<Car>) {
    fun getWinners(): List<String> {
        return findWinners()
    }

    private fun findWinners(): List<String> {
        val highestScore = cars.maxByOrNull { it.scoreSum }?.scoreSum
        return cars.filter { it.scoreSum == highestScore }.map { it.name }
    }
}