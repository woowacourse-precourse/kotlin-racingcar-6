package racingcar.model

import camp.nextstep.edu.missionutils.Randoms

object Round {
    fun generateRandomNumber() = Randoms.pickNumberInRange(0, 9)
    fun isForward(randomNumber: Int): Boolean = true.takeIf { randomNumber >= 4 } ?: false
}