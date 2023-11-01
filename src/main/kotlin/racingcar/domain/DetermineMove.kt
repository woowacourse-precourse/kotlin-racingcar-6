package racingcar.domain

import camp.nextstep.edu.missionutils.Randoms

class DetermineMove {

    private fun numberGenerator(): Int {
        return Randoms.pickNumberInRange(RANDOM_MIN_MUN, RANDOM_MAX_NUM)
    }

    fun isMove(): Boolean {
        val randomNum = numberGenerator()
        if (randomNum >= FORWARD_STANDARD_NUM) {
            return true
        }
        return false
    }

    companion object {
        const val RANDOM_MIN_MUN = 0
        const val RANDOM_MAX_NUM = 9
        const val FORWARD_STANDARD_NUM = 4
    }
}