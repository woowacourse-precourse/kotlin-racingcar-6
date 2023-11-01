package racingcar

import camp.nextstep.edu.missionutils.Randoms


class Racing {

    fun playRacing(tryCount : Int) {

    }


    private fun random09(): Int {
        val num = Randoms.pickNumberInRange(0, 9)
        println(num)
        return num
    }

    fun forwardOver4(cars: MutableList<Car>) {

        for (car in cars) {
            val forward = random09()

            printHyphen(car.name, forward)

            if (forward >= 4) {
                println("${car.name} : ${car.distance}")
                car.distance += 1
                println("${car.name} : ${car.distance}")
            }
        }

    }

    private fun printHyphen(carName: String, forward: Int) {
        println("$carName : ${"-".repeat(forward)}")
    }

}