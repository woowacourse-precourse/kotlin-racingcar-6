package racingcar.util

import camp.nextstep.edu.missionutils.Randoms

object RandomGenerator {

    private const val moveConditionStart = 0
    private const val moveConditionEnd = 9
    fun makeRandomNumber() = Randoms.pickNumberInRange(moveConditionStart, moveConditionEnd)
}