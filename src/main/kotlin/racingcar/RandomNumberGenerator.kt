package racingcar

import camp.nextstep.edu.missionutils.Randoms

class RandomNumberGenerator {
    companion object{
        private const val MIN = 0
        private const val MAX = 9
    }

    fun generateRandomNumber(): Int {
        return Randoms.pickNumberInRange(MIN, MAX)
    }
}