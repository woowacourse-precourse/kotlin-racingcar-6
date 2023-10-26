package racingcar.domain

interface Move {
    fun moveForward(): Int
    fun stop(): Int
}