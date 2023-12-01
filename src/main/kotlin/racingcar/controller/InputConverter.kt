package racingcar.controller

import racingcar.model.Cars

fun String.toCars(): Cars {
    require(this.isNotBlank()) { INPUT_CARS_BLANK }

    val list = this.split(INPUT_CARS_DELIMITERS).map { it.trim() }
    return Cars.withNames(*list.toTypedArray())
}

const val INPUT_CARS_BLANK = "경주할 자동차 이름을 입력하지 않았습니다."
const val INPUT_CARS_DELIMITERS = ','