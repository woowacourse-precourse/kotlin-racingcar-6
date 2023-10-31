package racingcar.utils

import camp.nextstep.edu.missionutils.Randoms

object RandomGenerator {
    fun generateRandomNumber(): Int = Randoms.pickNumberInRange(0, 9)
}