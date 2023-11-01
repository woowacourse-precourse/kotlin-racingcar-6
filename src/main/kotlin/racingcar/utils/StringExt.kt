package racingcar.utils

import racingcar.model.RacingCar

/** 사용자가 입력한 자동차의 이름들을 콤마(,)로 분리하여 Racing객체 List로 반환하는 함수 */
fun String.toRacingCar(): RacingCar = when {
    this.indexOf(" ") != -1 -> throw IllegalArgumentException()
    this.length !in Constants.NAME_LENGTH_RANGE -> throw IllegalArgumentException()
    else -> RacingCar(carName = this)
}
