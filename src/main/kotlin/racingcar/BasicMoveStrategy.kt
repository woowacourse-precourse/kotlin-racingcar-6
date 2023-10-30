package racingcar

import camp.nextstep.edu.missionutils.Randoms

class BasicMoveStrategy : MoveStrategyInterface {
    override fun calculateLocation(speed: Int, location: Int): Int {
        return if (getRandomNumber() >= 4) {
            location + speed
        } else {
            location
        }
    }

    private fun getRandomNumber(): Int {
        return Randoms.pickNumberInRange(0, 9)
    }
}