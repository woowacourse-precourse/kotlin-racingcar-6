package racingcar.util

import camp.nextstep.edu.missionutils.Randoms
class RandomGenerator(val start : Int, val end :Int) {
    fun pickNumber() : Int = Randoms.pickNumberInRange(start, end)
}