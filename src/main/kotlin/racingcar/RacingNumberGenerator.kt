package racingcar

import camp.nextstep.edu.missionutils.Randoms

class RacingNumberGenerator {

    fun get(): Int = Randoms.pickNumberInRange(MIN_RACING_NUMBER, MAX_RACING_NUMBER)

    companion object {
        private const val MIN_RACING_NUMBER = 0
        private const val MAX_RACING_NUMBER = 9
    }
}