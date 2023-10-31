package racingcar.car

import camp.nextstep.edu.missionutils.Randoms

interface MoveStrategy {
    fun isMovable(): Boolean
}

class MoveStrategyImpl : MoveStrategy {
    override fun isMovable(): Boolean {
        return Randoms.pickNumberInRange(0, 9) >= MIN_MOVING_FORWARD_NUMBER
    }

    companion object {
        const val MIN_MOVING_FORWARD_NUMBER = 4
    }
}