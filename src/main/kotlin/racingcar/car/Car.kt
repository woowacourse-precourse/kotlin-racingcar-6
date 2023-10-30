package racingcar.car

import racingcar.generator.NumberGenerator
import racingcar.generator.RandomNumberGenerator

abstract class Car(
    val name: String = "",
    scoreGenerator: NumberGenerator = RandomNumberGenerator()
) {
    val score = scoreGenerator.generate()
    var position = ""
        protected set

    abstract fun move()

    override fun toString() = name
}