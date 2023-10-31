package racingcar.util

import camp.nextstep.edu.missionutils.Randoms

object RandomGenerator {

    fun makeRandomNumber() = Randoms.pickNumberInRange(0, 9)
}