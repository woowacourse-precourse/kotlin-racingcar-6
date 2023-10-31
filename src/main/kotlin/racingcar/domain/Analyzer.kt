package racingcar.domain

import racingcar.data.Car

class Analyzer {

    fun judgeWinner(cars: List<Car>): List<Car> {
        var maxNum = Int.MIN_VALUE

        return cars.fold(mutableListOf()) { winners: MutableList<Car>, car ->
            if (car.location < maxNum) {
                return@fold winners
            } else if (car.location > maxNum) {
                winners.clear()
                maxNum = car.location
            }
            winners.add(car)
            winners
        }.toList()
    }

    fun isMoveAllowed(num: Int): Boolean = num >= MIN_PASSING_NUM

    companion object {
        private const val MIN_PASSING_NUM = 4

    }
}