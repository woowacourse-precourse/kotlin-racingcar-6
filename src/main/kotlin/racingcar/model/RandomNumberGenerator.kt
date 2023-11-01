package racingcar.model

import camp.nextstep.edu.missionutils.Randoms

class RandomNumberGenerator {
    fun generator(): Int {
        return Randoms.pickNumberInRange(Constants.MIN, Constants.MAX)
    }
}