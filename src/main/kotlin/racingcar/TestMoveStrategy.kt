package racingcar

class TestMoveStrategy(private val numberList: List<Int>) : MoveStrategyInterface {
    private var pointer = 0
    override fun calculateLocation(speed: Int, location: Int): Int {
        return if (numberList[pointer++] >= 4) {
            location + speed
        } else {
            location
        }
    }
}