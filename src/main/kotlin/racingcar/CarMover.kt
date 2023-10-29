package racingcar

import camp.nextstep.edu.missionutils.Randoms.pickNumberInRange
import model.CarModel

class CarMover {
    companion object {
        private const val RANDOM_NUMBER_START = 0
        private const val RANDOM_NUMBER_LAST = 9
        private const val RANDOM_MAX_VALUE = 4
        fun move(cars: List<CarModel>) {
            for (car in cars) {
                val randomValue = getRandomNumber()
                if (randomValue >= RANDOM_MAX_VALUE) {
                    car.position++
                    println("${car.name} : ${"-".repeat(car.position)}")
                } else {
                    println("${car.name} : ${"-".repeat(car.position)}")
                }
            }
            println("")
        }
        private fun getRandomNumber(): Int {
            return pickNumberInRange(RANDOM_NUMBER_START, RANDOM_NUMBER_LAST)
        }
    }
}