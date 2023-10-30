package racingcar.domain

import racingcar.domain.car.Car
import racingcar.domain.car.Cars

class Controller {
    fun playRound(cars: Cars, randomNumber:Int): Cars {
        cars.getCars().all {
            it.move(randomNumber)
            println(it.printResult())
            cars.compareHighScore(it.getDistance())
            true
        }
        return cars
    }

    fun printWinner(cars: Cars): String {
        var result = "최종 우승자 : "
        cars.getCars().all {
            result += decideWinner(cars, it)
            true
        }
        result+="\n"
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