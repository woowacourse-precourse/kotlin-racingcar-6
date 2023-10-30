package racingcar.util

import racingcar.constants.Delimiter
import racingcar.model.Car

fun String.toCarList() = this
    .split(Delimiter.CAR.toString()) // 문자열 구분자 ","
    .map { carName -> Car.of(carName) }

fun String.isLetter() = this.all { it.isLetter() }

fun String.isDigit() = this.all { it.isDigit() }

fun String.isGreater(other: String) = this.length > other.length || this >= other