package racingcar.domain.car.dto.input

import racingcar.domain.car.CarRacing
import racingcar.domain.car.CarsRacing

data class CreateCarsDto(
    private val carNames: List<String>,
) {

    fun into(): CarsRacing {
        return CarsRacing(
            carNames.map {
                CarRacing(it)
            },
        )
    }


}