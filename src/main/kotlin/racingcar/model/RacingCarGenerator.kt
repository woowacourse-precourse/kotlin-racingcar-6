package racingcar.model

class RacingCarGenerator {
    val racingCarValidation = RacingCarValidation()
    fun addPlayer(name: String): RacingCar {
        racingCarValidation.validation(name)
        return RacingCar(name, INIT_DIST)
    }

    companion object {
        private const val INIT_DIST = 0
    }
}
