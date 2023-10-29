package racingcar.domain

import racingcar.domain.car.Car
import racingcar.domain.car.Cars

class Controller {
    fun playRound(cars: Cars): Cars {
        cars.getCars().all {
            it.move()
            it.printResult()
            cars.compareHighScore(it.getDistance())
            true
        }
        return cars
    }
    fun printWinner(cars: Cars) {
        print("최종 우승자 : ")
        cars.getCars().all {
            decideWinner(cars,it)
            true
        }
        println()
    }
    private fun decideWinner(cars: Cars, it: Car){
        if (cars.isEqualHighScore(it.getDistance())) {
            val name = it.name
            if (cars.isFirst()) {
                print(name)
            }
            else print(", $name")
        }
    }

}