package racingcar.domain

import racingcar.domain.car.Car
import racingcar.domain.car.Cars

class Controller {
    fun playRound(car: Car, randomNumber: Int) {
        car.move(randomNumber)
        println(car.printResult())
    }

    fun printWinner(cars: Cars): String {
        var result = "최종 우승자 : "
        cars.getCars().all {
            result += decideWinner(cars, it)
            true
        }
        return result
    }

    private fun decideWinner(cars: Cars, it: Car): String {
        if (cars.isEqualHighScore(it.getDistance())) {
            val name = it.name
            if (cars.isFirst()) {
                return name
            } else return ", $name"
        }
        return ""
    }

}