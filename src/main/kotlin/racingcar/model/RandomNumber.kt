package racingcar.model

import camp.nextstep.edu.missionutils.Randoms
import racingcar.util.END_RANDOM_RANGE
import racingcar.util.START_RANDOM_RANGE

class RandomNumber {
    fun randomNumberGenerator(): Int {
        val randomNumber = Randoms.pickNumberInRange(START_RANDOM_RANGE, END_RANDOM_RANGE)
        return randomNumber
    }
}