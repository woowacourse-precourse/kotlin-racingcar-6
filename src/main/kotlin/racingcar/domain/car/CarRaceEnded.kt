package racingcar.domain.car

import racingcar.domain.car.boxed.CarName
import racingcar.domain.distance.boxed.Distance

class CarRaceEnded(
    val _carName: CarName,
    val _distance: Distance,
) : Car {

    val carName
        get() = _carName.carName

    val distance
        get() = _distance.distance

    companion object {
        fun intoWinnerNamesResult() {

        }
    }
}