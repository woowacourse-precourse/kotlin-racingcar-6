package racingcar

import camp.nextstep.edu.missionutils.Randoms

class RandomNumProducer {

    fun makeRandomNum() : Int {

        val randomNum = Randoms.pickNumberInRange(0,9)

        return randomNum
    }

}