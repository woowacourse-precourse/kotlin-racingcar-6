package racingcar.domain

import camp.nextstep.edu.missionutils.Randoms

class NumberGenerator {
    fun createRandomNumber(): Int {
        return Randoms.pickNumberInRange(0, 9)
    }
}