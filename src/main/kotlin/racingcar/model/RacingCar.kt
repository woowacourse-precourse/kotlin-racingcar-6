package racingcar.model

import racingcar.utils.Constants

class RacingCar(
    var carName: String,
    var location: Int = 5,
) {
    override fun toString(): String {
        return "$carName : " + Constants.CAR_LOCATION.repeat(location)
    }
}