package racingcar

import camp.nextstep.edu.missionutils.Randoms

class RandomNumProducer {

    fun makeRandomNum(): Int {

        return Randoms.pickNumberInRange(0, 9)
    }

}