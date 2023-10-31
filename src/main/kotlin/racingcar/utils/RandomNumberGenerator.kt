package racingcar.utils

import camp.nextstep.edu.missionutils.Randoms

class RandomNumberGenerator {

    companion object {
        const val MIN_NUMBER = 0
        const val MAX_NUMBER = 9
    }

    fun createNumber(): Int {

        return Randoms.pickNumberInRange(MIN_NUMBER, MAX_NUMBER)
    }
}