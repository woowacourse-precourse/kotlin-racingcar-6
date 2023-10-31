package utils

import camp.nextstep.edu.missionutils.Randoms

object RandomNumGenerator {
    fun getRandomNum(): Int {
        return Randoms.pickNumberInRange(0, 9)
    }
}