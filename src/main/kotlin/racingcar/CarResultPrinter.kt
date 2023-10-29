package racingcar

import model.CarModel

class CarResultPrinter {
    companion object {
        fun printResult(cars: List<CarModel>) {
            val maxPosition = cars.maxOfOrNull { it.position }
            val winners = cars.filter { it.position == maxPosition }.joinToString(", ") { it.name }
            println("최종 우승자 : $winners")
        }
    }
}