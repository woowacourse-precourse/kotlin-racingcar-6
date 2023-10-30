package racingcar.utils

import camp.nextstep.edu.missionutils.Randoms

object RandomGenerator {
    fun generateRandomNumber(): Int = Randoms.pickNumberInRange(Constants.RANGE_START, Constants.RANGE_END)
}