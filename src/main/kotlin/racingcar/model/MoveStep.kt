package racingcar.model

import camp.nextstep.edu.missionutils.Randoms
import racingcar.util.Constants.MOVE_FORWARD
import racingcar.util.Constants.MOVE_STOP

object MoveStep {

    fun move(): Int {
        return if (moveCondition())
            MOVE_FORWARD
        else
            MOVE_STOP
    }

    private fun moveCondition(): Boolean {
        val value = Randoms.pickNumberInRange(0, 9)
        return value >= 4
    }
}