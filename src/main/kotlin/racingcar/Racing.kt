package racingcar

import camp.nextstep.edu.missionutils.Randoms

class Racing {
    fun playRacing(tryCount: Int, cars: MutableList<Car>) {
        for (count in 1..tryCount) {
            forwardOverFour(cars)
        }
    }

    private fun randomZeroNine(): Int {

        return Randoms.pickNumberInRange(0, 9)

    }

    private fun forwardOverFour(cars: MutableList<Car>) {

        for (car in cars) {
            val forward = randomZeroNine()

            printHyphen(car.name, forward)

            if (forward >= 4) {
                car.distance += 1
            }

        }

        println()

    }

    private fun printHyphen(carName: String, forward: Int) {
        println("$carName : ${"-".repeat(forward)}")
    }


}