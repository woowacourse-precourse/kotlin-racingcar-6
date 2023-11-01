package racingcar.domain

import racingcar.data.Car

class Analyzer {

    fun judgeWinner(cars: List<Car>): List<Car> {
        val winners = mutableListOf<Car>()
        var maxLocation = NOT_YET_SET

        for (car in cars) {
            if (car.location > maxLocation) {
                winners.clear()
                winners.add(car)
                maxLocation = car.location
            } else if (car.location == maxLocation) {
                winners.add(car)
            }
        }
        return winners.toList()
    }

    fun isMoveAllowed(num: Int): Boolean = num >= MIN_PASSING_NUM

    companion object {
        private const val MIN_PASSING_NUM = 4
        private const val NOT_YET_SET = Int.MIN_VALUE
    }
}