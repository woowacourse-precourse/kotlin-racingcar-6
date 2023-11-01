package racingcar.model

import racingcar.utils.Constants

data class RacingCar(
    var carName: String,
    var location: Int = 0,
) : Comparable<RacingCar> {

    override fun toString(): String = "$carName : " + Constants.CAR_LOCATION.repeat(location)

    override fun compareTo(other: RacingCar): Int =
        when {
            location > other.location -> -1
            location < other.location -> 1
            else -> 0
        }
}