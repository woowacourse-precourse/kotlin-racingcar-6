package racingcar.domain

import camp.nextstep.edu.missionutils.Randoms

class DetermineMove {

    private fun numberGenerator(): Int {
        return Randoms.pickNumberInRange(0, 9)
    }

    fun isMove(): Boolean {
        val randomNum = numberGenerator()
        if (randomNum >= 4) {
            return true
        }
        return false
    }
}