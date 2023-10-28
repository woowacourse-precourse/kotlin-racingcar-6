package racingcar.domain.car

import racingcar.domain.car.boxed.CarName
import racingcar.domain.car.dto.result.CarDto
import racingcar.domain.distance.boxed.Distance

class CarRacing(
    private val _name: CarName,
    private val _distance: Distance = Distance.zero(),
) : Car {

    val name
        get() = _name.carName

    val distance
        get() = _distance.distance

    fun move() {
        _distance.increase()
    }

    fun intoCarDto() =
        CarDto(name, distance)

    fun intoCarRaceEnded() = CarRaceEnded(_name, _distance)

    companion object {
        fun from(name: String) = CarRacing(CarName(name))

    }
}