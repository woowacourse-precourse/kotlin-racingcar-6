package racingcar

class RacingCarGameStatePrinter {
    companion object {
        const val DISTANCE_EXPRESSION = "-"
    }

    private fun printState(car: RacingCar) {
        val sb = StringBuilder()
        for(i in 0 until car.distance) {
            sb.append(DISTANCE_EXPRESSION)
        }
        println("${car.name} : $sb")
    }

    fun printAllCarsState(cars: MutableList<RacingCar>) {
        for(car in cars) {
            printState(car)
        }
        println()
    }
}