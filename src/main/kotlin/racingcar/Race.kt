package racingcar

import racingcar.car.Car
import racingcar.model.RaceResult

class Race(
    private val attemptCount: Int,
    private val cars: List<Car>,
    private val referee: Referee = Referee(attemptCount),
) {
    val winner get() = referee.determineWinner(cars)
    val isRunning get() = winner.cars.isEmpty()

    fun runOneStep(): RaceResult {
        cars.forEach { car -> car.move() }
        return referee.determineRaceResult(cars)
    }
}