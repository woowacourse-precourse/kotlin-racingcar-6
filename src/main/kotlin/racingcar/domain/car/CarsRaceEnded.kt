package racingcar.domain.car

import racingcar.domain.car.dto.output.WinnersDto

class CarsRaceEnded(
    private val cars: List<CarRaceEnded>,
) : Cars {

    fun intoWinnersDto(): WinnersDto {
        val maxDistance = maxDistance()
        return WinnersDto(
            cars
                .filter { it.distance == maxDistance }
                .map { it.intoWinnerDto() },
        )
    }

    private fun maxDistance() =
        cars.maxBy { it.distance.value }.distance
}