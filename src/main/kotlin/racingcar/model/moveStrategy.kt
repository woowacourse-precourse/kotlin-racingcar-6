package racingcar.model

import camp.nextstep.edu.missionutils.Randoms
import racingcar.model.MoveStrategy.Companion.FORWARD_THRESHOLD
import racingcar.model.MoveStrategy.Companion.MAXIMUM_DIGIT
import racingcar.model.MoveStrategy.Companion.MINIMUM_DIGIT

interface MoveStrategy {

    fun canMove(): Boolean

    companion object {
        const val MINIMUM_DIGIT = 0
        const val MAXIMUM_DIGIT = 9
        const val FORWARD_THRESHOLD = 4
    }
}

class RandomMoveStrategy : MoveStrategy {
    override fun canMove(): Boolean {
        val random = Randoms.pickNumberInRange(MINIMUM_DIGIT, MAXIMUM_DIGIT)
        return FORWARD_THRESHOLD <= random
    }
}