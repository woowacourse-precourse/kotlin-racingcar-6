package racingcar.model

interface MoveStrategy {
    fun canMoveForward(car: Car): Boolean
}