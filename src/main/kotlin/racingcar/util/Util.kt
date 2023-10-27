package racingcar.util

import racingcar.model.Car

fun String.toCarNameList() = this.split(",")

fun List<String>.toCarList() = this.map { Car.of(it) }