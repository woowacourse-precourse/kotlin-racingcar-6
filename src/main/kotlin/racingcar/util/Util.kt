package racingcar.util

import racingcar.constants.Delimiter
import racingcar.model.Car

fun String.toCarList() = this
    .split(Delimiter.CAR.toString()) // 문자열 구분자 ","
    .map { carName -> Car.of(carName) }