package racingcar

import camp.nextstep.edu.missionutils.Randoms

class RandomNumber {
    fun createRandomNumber(): Int {
        return Randoms.pickNumberInRange(0, 9)
    }
}