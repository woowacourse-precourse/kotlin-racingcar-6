package racingcar

import camp.nextstep.edu.missionutils.Randoms

class Random {
    fun generatorRandomNum(): Int {
        val randomNumber = Randoms.pickNumberInRange(0, 9)
        return randomNumber
    }
}
