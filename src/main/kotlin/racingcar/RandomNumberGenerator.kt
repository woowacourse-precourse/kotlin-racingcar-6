package racingcar

import camp.nextstep.edu.missionutils.Randoms

class RandomNumberGenerator {
    companion object{
        private const val MIN_NUMBER = 1
        private const val MAX_NUMBER = 9
    }

    fun generateRandomNumber(): Int {
        return Randoms.pickNumberInRange(MIN_NUMBER, MAX_NUMBER)
    }
}