package racingcar

object RacePrinter {
    private const val DASH = "-"
    private const val COLON = " : "

    fun showCurrentRace(cars: List<Car>) {
        cars.map { car ->
            println(car.name + COLON + DASH.repeat(car.position))
        }
        println()
    }
