package racingcar.domain

import racingcar.data.Car

class Analyzer {

    fun judgeWinner(cars: List<Car>): List<Car> {
        val winners = mutableListOf<Car>()
        var maxNum = Int.MIN_VALUE

        for (car in cars) {
            if (car.location > maxNum) {
                winners.clear()
                winners.add(car)
                maxNum = car.location
            } else if (car.location == maxNum) {
                winners.add(car)
            }
        }
        return winners
    }

    fun isMoveAllowed(num: Int): Boolean = num >= MIN_PASSING_NUM

    companion object {
        private const val MIN_PASSING_NUM = 4

    }
}