package racingcar.util

import camp.nextstep.edu.missionutils.Randoms

object Util {
    fun separateNameByComma(carNames: String): List<String> = carNames.split(",")

    fun getRandomNumber(): Int = Randoms.pickNumberInRange(Constants.START_NUMBER, Constants.END_NUMBER)

    fun isMovable(number: Int): Boolean = number >= Constants.MOVABLE_NUMBER
}