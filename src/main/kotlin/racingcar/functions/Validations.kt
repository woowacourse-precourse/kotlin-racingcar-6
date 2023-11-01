package racingcar.functions

import racingcar.Cars
import racingcar.Constants

fun validateCarNames(cars: List<Cars>) {
    validateCarNameLength(cars)
    validateEmptyCarNames(cars)
    validateDuplicateCarNames(cars)
    validateMinimumCarNumber(cars)
}

fun validateRaceRound(raceRound: Int) {
    if (raceRound <= Constants.RACE_ROUND_RULE) {
        throw IllegalArgumentException(Constants.NOT_POSITIVE_INTEGER_ALARM)
    }
}

fun validateCarNameLength(cars: List<Cars>) {
    if (cars.any { it.name.length > Constants.NAME_LENGTH_RULE }) {
        throw IllegalArgumentException(Constants.OVER_INPUT_ALARM)
    }
}

fun validateEmptyCarNames(cars: List<Cars>) {
    if (cars.any { it.name.isBlank() }) {
        throw IllegalArgumentException(Constants.EMPTY_INPUT_NAME_ALARM)
    }
}

fun validateDuplicateCarNames(cars: List<Cars>) {
    if (cars.map { it.name }.distinct().size != cars.size) {
        throw IllegalArgumentException(Constants.DUPLICATION_NAME_ALARM)
    }
}

fun validateMinimumCarNumber(cars: List<Cars>) {
    if (cars.size <= 1) {
        throw IllegalArgumentException(Constants.AT_LEAST_TWO_CAR_NEED_ALARM)
    }
}

