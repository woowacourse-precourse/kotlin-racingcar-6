package racingcar.util

import camp.nextstep.edu.missionutils.Randoms

object RandomNumberGenerator {
    fun generateRandomNumber(): Int = Randoms.pickNumberInRange(MIN_NUMBER, MAX_NUMBER)

    private const val MIN_NUMBER = 0
    private const val MAX_NUMBER = 9
}