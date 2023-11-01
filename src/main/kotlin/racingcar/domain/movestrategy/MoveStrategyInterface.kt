package racingcar.domain.movestrategy

interface MoveStrategyInterface {
    fun calculateLocation(speed: Int, location: Int): Int
}