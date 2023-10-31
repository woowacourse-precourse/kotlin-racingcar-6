package racingcar.car

import racingcar.randomnumbergenerator.RandomNumberGenerator

interface Car {
    val currentPosition: String

    fun forwardOrStop(randomNumberGenerator: RandomNumberGenerator)
}