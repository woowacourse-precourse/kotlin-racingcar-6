package racingcar.model

class RacingCarGenerator {
    val racingCarValidation = RacingCarValidation()
    fun addPlayer(name: String): Racingcar {
        racingCarValidation.validation(name)
        return Racingcar(name, INIT_DIST)
    }

    companion object {
        private const val INIT_DIST = 0
    }
}