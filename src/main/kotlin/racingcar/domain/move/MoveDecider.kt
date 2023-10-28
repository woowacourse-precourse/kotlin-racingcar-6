package racingcar.domain.move

interface MoveDecider {
    fun nextMove(): Movement
}