package racingcar.model.car

fun interface RandomNumberGenerator {
    fun generateIntInRange(min: Int, max: Int): Int
}