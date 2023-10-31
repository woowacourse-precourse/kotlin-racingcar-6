package racingcar.utils

import camp.nextstep.edu.missionutils.Randoms

class RandomUtils {

    companion object {
        const val MIN_VALUE = 0
        const val MAX_VALUE = 9
    }

    fun getRandom() = Randoms.pickNumberInRange(MIN_VALUE, MAX_VALUE)
}
