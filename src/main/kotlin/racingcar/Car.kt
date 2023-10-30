package racingcar

import racingcar.generator.RandomNumberGenerator

abstract class Car(
    val name: String = "",
    private val scoreGenerator: RandomNumberGenerator = RandomNumberGenerator()
) {
    var position = ""
        protected set
    val score get() = scoreGenerator.generate()

    abstract fun move()

    override fun toString() = name
}