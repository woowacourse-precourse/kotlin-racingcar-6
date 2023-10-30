package racingcar

import racingcar.car.Car

class Race(
    private val attemptCount: Int,
    private val cars: List<Car>,
    private val referee: Referee = Referee(attemptCount)
) {
    val result get() = referee.determineRaceResult(cars)
    val winner get() = referee.determineWinner(cars)
    val isRunning get() = winner.cars.isEmpty()

    fun runOnStep() {
        cars.forEach { car ->
            if (referee.canCarMove(car.score)) car.move()
        }
    }
}