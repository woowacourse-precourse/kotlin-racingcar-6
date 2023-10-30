package racingcar

import racingcar.car.Car
import racingcar.model.CarState
import racingcar.model.RaceResult
import racingcar.model.Winner

class Referee(
    private val attemptCount: Int
) {
    fun canCarMove(score: Int) = (score >= MOVE_START_NUMBER)

    fun determineRaceResult(cars: List<Car>): RaceResult {
        return RaceResult(
            cars.map { car ->
                CarState(car.name, car.position)
            }
        )
    }

    fun determineWinner(cars: List<Car>): Winner {
        val winners = cars.filter { car -> car.position.length == attemptCount }
        return Winner(winners)
    }

    companion object {
        private const val MOVE_START_NUMBER = 4
    }
}