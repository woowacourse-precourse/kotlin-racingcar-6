package racingcar

interface MoveStrategyInterface {
    fun calculateLocation(speed: Int, location: Int): Int
}