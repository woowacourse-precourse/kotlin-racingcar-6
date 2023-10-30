package racingcar

import camp.nextstep.edu.missionutils.Randoms

class GameResultGenerator(private val cars: List<Car>) {

    fun result() {
        moveCars()
        printCarStatus()
    }

    private fun moveCars() {
        cars.forEach {
            if (canMove()) it.scoreSum++
        }
    }

    private fun printCarStatus() {
        cars.forEach {
            println("${it.name} : ${"-".repeat(it.scoreSum)}")
        }
        println()
    }

    private fun getGeneratedRandomNumber() = Randoms.pickNumberInRange(MIN_NUMBER, MAX_NUMBER)

    private fun canMove(): Boolean {
        return getGeneratedRandomNumber() > STANDARD_NUMBER
    }

    companion object {
        const val MIN_NUMBER = 0
        const val MAX_NUMBER = 9
        const val STANDARD_NUMBER = 4
    }

}