package racingcar.utils

import camp.nextstep.edu.missionutils.Randoms

object Round {
    const val RANDOM_RANGE_START = 0
    const val RANDOM_RANGE_END = 9

    const val FORWARD_THRESHOLD = 4

    fun generateRandomNumber() = Randoms.pickNumberInRange(RANDOM_RANGE_START, RANDOM_RANGE_END)

    fun isForward(randomNumber: Int): Boolean =
        true.takeIf { randomNumber >= FORWARD_THRESHOLD } ?: false
}