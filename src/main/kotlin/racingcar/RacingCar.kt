package racingcar

class RacingCar private constructor(
    val name: String
) {

    var movingCount = 0
        private set

    fun move() {
        ++movingCount
    }

    companion object {
        private const val MAX_NAME_LENGTH = 5

        fun createOrThrow(name: String): RacingCar {
            require(name.length in 1..MAX_NAME_LENGTH)
            return RacingCar(name = name)
        }
    }
}