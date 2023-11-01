package racingcar.car

import racingcar.randomnumbergenerator.RandomNumberGenerator

interface Car {
    val name: String
    val currentPosition: String

    fun forwardOrStop(randomNumber: Int)
}