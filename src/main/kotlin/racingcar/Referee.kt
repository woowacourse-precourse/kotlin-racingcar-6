package racingcar

import racingcar.car.Car
import racingcar.model.CarState
import racingcar.model.RaceResult
import racingcar.model.Winner

class Referee(
    private val attemptCount: Int
) {
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
}