package racingcar.domain

import camp.nextstep.edu.missionutils.Randoms
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

    fun isMoveAllowed(): Boolean = getRandomNum() >= MIN_PASSING_NUM

    private fun getRandomNum(): Int = Randoms.pickNumberInRange(MIN_RANDOM_NUM, MAX_RANDOM_NUM)

    companion object {
        private const val MIN_PASSING_NUM = 4
        private const val MIN_RANDOM_NUM = 0
        private const val MAX_RANDOM_NUM = 9
    }
}