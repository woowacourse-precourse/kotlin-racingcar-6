package racingcar.car

import racingcar.generator.NumberGenerator
import racingcar.generator.RandomNumberGenerator

class Car(
    val name: String = "",
    private val scoreGenerator: NumberGenerator = RandomNumberGenerator(),
) {
    val score get() = scoreGenerator.generate()
    private val canMove get() = (score >= MOVE_START_NUMBER)
    var position = ""
        private set

    fun move(): String {
        if (canMove) position += POSITION_UNIT
        return position
    }

    override fun toString() = name

    companion object {
        private const val POSITION_UNIT = "-"
        private const val MOVE_START_NUMBER = 4
    }
}