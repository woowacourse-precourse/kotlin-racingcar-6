package racingcar.view

import racingcar.model.Cars

class OutputCars {
    fun showRace(cars: Cars) {
        cars.cars.forEach {
            println(it.name + " : " + "-".repeat(it.position))
        }
        println()
    }
}