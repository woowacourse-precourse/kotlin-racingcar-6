package racingcar

class RacingCarGameStatePrinter {
    companion object {
        const val DISTANCE_EXPRESSION = "-"
    }

    private fun printCarDistance(car: RacingCar) {
        val sb = StringBuilder()
        for(i in 0 until car.distance) {
            sb.append(DISTANCE_EXPRESSION)
        }
        println("${car.name} : $sb")
    }

    fun printAllCarsDistance(cars: MutableList<RacingCar>) {
        for(car in cars) {
            printCarDistance(car)
        }
        println()
    }
}