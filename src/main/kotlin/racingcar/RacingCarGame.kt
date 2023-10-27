package racingcar

class RacingCarGame {
    private val cars = mutableListOf<Car>()

    fun moveAllCarsOneStep() {
        for(car in cars) {
            car.move()
        }
    }

    fun printAllCarsState() {
        for(car in cars) {
            car.printState()
        }
        println()
    }
}