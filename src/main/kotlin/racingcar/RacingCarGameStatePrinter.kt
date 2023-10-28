package racingcar

class RacingCarGameStatePrinter {
    companion object {
        const val distanceString = "-"
    }

    private fun printState(car: Car) {
        val sb = StringBuilder()
        for(i in 0 until car.distance) {
            sb.append(distanceString)
        }
        println("${car.name} : $sb")
    }

    fun printAllCarsState(cars: MutableList<Car>) {
        for(car in cars) {
            printState(car)
        }
        println()
    }
}