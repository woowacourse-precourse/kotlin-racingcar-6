package racingcar

import camp.nextstep.edu.missionutils.Randoms

class Racing {

    fun random09() : Int {
        val num = Randoms.pickNumberInRange(0, 9)
        println(num)
        return num

    }

    fun forwardOver4(cars: MutableList<Car>) {

        for (car in cars) {
            if (random09() >= 4) {
                println("${car.name} : ${car.distance}")
                car.distance += 1
                println("${car.name} : ${car.distance}")
            }
        }

    }

    fun printHyphen() {

    }

}