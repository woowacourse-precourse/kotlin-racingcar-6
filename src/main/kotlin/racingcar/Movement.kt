package racingcar

import camp.nextstep.edu.missionutils.Randoms

class Movement(private val cars: List<Car>) {
    fun moveCars() = cars.filter { canMove() }.forEach { it.scoreSum++ }
    private fun getGeneratedRandomNumber() = Randoms.pickNumberInRange(MIN_NUMBER, MAX_NUMBER)
    private fun canMove() = getGeneratedRandomNumber() >= STANDARD_NUMBER

    companion object {
        const val MIN_NUMBER = 0
        const val MAX_NUMBER = 9
        const val STANDARD_NUMBER = 4
    }
}