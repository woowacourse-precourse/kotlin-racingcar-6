package racingcar.domain.car

import racingcar.domain.car.dto.result.CarsDto

class CarsRacing(
    private val cars: List<CarRacing>,
) : Cars {
    fun moveAllBy() {}

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