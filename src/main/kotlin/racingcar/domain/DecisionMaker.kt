package racingcar.domain

import camp.nextstep.edu.missionutils.Randoms

class DecisionMaker() {

    companion object {
        const val MIN_DIGIT = 0
        const val MAX_DIGIT = 9
        const val FORWARD_THRESHOLD = 4
    }

    fun decideToMove(): Boolean {
        val random = Randoms.pickNumberInRange(MIN_DIGIT, MAX_DIGIT)
        return random >= FORWARD_THRESHOLD
    }
}