package racingcar

class CarFactory() {
    var maxDistance = 0
    fun displyCarRace(car: List<Car>, tryGame: Int): Int {
        repeat(tryGame) {
            car.forEach { it.checkMove() }
            val max = car.maxOfOrNull { it.distance }
            if (max != null && max > maxDistance) {
                maxDistance = max
            }
            car.forEach { println(it.display()) }
            println()
        }
        return maxDistance
    }
}