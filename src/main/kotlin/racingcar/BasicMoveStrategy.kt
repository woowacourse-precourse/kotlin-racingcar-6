package racingcar

import camp.nextstep.edu.missionutils.Randoms
import racingcar.Const.MOVE_POINT_NUMBER

class BasicMoveStrategy : MoveStrategyInterface {
    override fun calculateLocation(speed: Int, location: Int): Int {
        return if (getRandomNumber() >= MOVE_POINT_NUMBER) {
            location + speed
        } else {
            location
        }
    }

    private fun getRandomNumber(): Int {
        return Randoms.pickNumberInRange(0, 9)
    }
}