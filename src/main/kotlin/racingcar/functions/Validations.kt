package racingcar.functions

import racingcar.Cars
import racingcar.Constants

fun validateCarNames(cars: List<Cars>) {
    if (cars.any { it.name.length > Constants.NAME_LENGTH_RULE }) {
        throw IllegalArgumentException(Constants.OVER_INPUT_ALARM)
    }
}

fun validateRaceRound(raceRound: Int) {
    if (raceRound <= Constants.RACE_ROUND_RULE) {
        throw IllegalArgumentException(Constants.NOT_POSITIVE_INTEGER_ALARM)
    }
}