package racingcar.domain.car

import racingcar.domain.car.boxed.CarName
import racingcar.domain.car.dto.output.CarDto
import racingcar.domain.distance.boxed.Distance

class CarRacing(name: String) : Car {

    private val _name: CarName = CarName(name)
    private val _distance: Distance = Distance.zero()

    private val name
        get() = _name.value

    private val distance
        get() = _distance.value

    fun move() {
        _distance.increase()
    }

    fun intoCarDto() =
        CarDto(_name.value, distance)

    fun intoCarRaceEnded() = CarRaceEnded(_name, _distance)

}