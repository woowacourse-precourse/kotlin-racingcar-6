package racingcar.domain.car

import racingcar.domain.car.boxed.CarName
import racingcar.domain.car.dto.output.WinnerDto
import racingcar.domain.distance.boxed.Distance

data class CarRaceEnded(
    val carName: CarName,
    val distance: Distance,
) : Car {

    fun intoWinnerDto() = WinnerDto(carName.value)
}