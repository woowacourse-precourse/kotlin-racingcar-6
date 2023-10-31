package racingcar.game

import racingcar.car.Car

class Round(
    private val cars: List<Car>
) {
    fun start() {
        cars.forEach { car ->
            car.moveForward()
        }
    }

    fun result(): String {
        val stringBuilder = StringBuilder()
        cars.forEach { car ->
            stringBuilder.appendLine(car)
        }
        stringBuilder.appendLine()

        return stringBuilder.toString()
    }

    fun printResult() {
        println(result())
    }
}