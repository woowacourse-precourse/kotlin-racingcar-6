package racingcar

import camp.nextstep.edu.missionutils.Randoms
import racingcar.Constants.FORWARD_THRESHOLD
import racingcar.Constants.MAXIMUM_DIGIT
import racingcar.Constants.MINIMUM_DIGIT

interface MoveStrategy {
    fun canMove(): Boolean
}

class RandomMoveStrategy : MoveStrategy {
    override fun canMove(): Boolean {
        val random = Randoms.pickNumberInRange(MINIMUM_DIGIT, MAXIMUM_DIGIT)
        return FORWARD_THRESHOLD <= random
    }
}