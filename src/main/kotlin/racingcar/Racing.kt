package racingcar

import camp.nextstep.edu.missionutils.Randoms


class Racing {

    fun playRacing(tryCount: Int, cars: MutableList<Car>) {
        for (count in 0..<tryCount) {
            forwardOver4(cars)
        }
    }


    private fun random09(): Int {
        val num = Randoms.pickNumberInRange(0, 9)

        return num
    }

    fun forwardOver4(cars: MutableList<Car>) {

        for (car in cars) {
            val forward = random09()

            printHyphen(car.name, forward)

            if (forward >= 4) {

                car.distance += 1

            }
        }
    }

    private fun printHyphen(carName: String, forward: Int) {
        println("$carName : ${"-".repeat(forward)}")
    }

}