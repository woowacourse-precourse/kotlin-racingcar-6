package racingcar.util

import racingcar.model.Car

fun String.toCarList() = this.split(",").map { carName -> Car.of(carName) }