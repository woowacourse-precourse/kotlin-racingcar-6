package racingcar

import racingcar.Const.MOVE_POINT_NUMBER

class TestMoveStrategy(private val numberList: List<Int>) : MoveStrategyInterface {
    private var pointer = 0
    override fun calculateLocation(speed: Int, location: Int): Int {
        return if (numberList[pointer++] >= MOVE_POINT_NUMBER) {
            location + speed
        } else {
            location
        }
    }
}