package racingcar.car

import racingcar.generator.NumberGenerator
import racingcar.generator.RandomNumberGenerator

class Car(
    val name: String = "",
    private val scoreGenerator: NumberGenerator = RandomNumberGenerator(),
) {
    val score get() = scoreGenerator.generate()
    var position = ""
        private set

    fun move() {
        position += POSITION_UNIT
    }

    override fun toString() = name

    companion object {
        private const val POSITION_UNIT = "-"
    }
}