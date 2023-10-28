package racingcar

import camp.nextstep.edu.missionutils.Randoms

object RandomGenerator {

    fun pickNumber(start: Int, end: Int): Int = Randoms.pickNumberInRange(start, end)
}