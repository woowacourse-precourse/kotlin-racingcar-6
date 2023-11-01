package racingcar.domain.car

import racingcar.domain.car.dto.output.CarsDto
import racingcar.domain.move.MoveDecider
import racingcar.domain.move.Movement

class CarsRacing(
    private val cars: List<CarRacing>,
) : Cars {
    fun moveAllBy(moveDecider: MoveDecider) {
        cars.forEach {
            val movement = moveDecider.nextMove()
            if (movement == Movement.FORWARD) {
                it.move()
            }
        }
    }

    fun intoCarsDto() =
        CarsDto(
            cars.map {
                it.intoCarDto()
            },
        )

    fun intoCarsRaceEnded() =
        CarsRaceEnded(
            cars.map {
                it.intoCarRaceEnded()
            },
        )
}