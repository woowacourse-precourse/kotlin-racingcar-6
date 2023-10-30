package racingcar.car

import racingcar.generator.RandomNumberGenerator

abstract class Car(
    val name: String = "",
    private val scoreGenerator: RandomNumberGenerator = RandomNumberGenerator()
) {
    val score = scoreGenerator.generate()
    var position = ""
        protected set

    abstract fun move()

    override fun toString() = name
}