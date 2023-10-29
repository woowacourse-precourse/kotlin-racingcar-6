package racingcar.model

class RacingCarGenerator {
    private val racingCarValidation = RacingCarValidation()
    fun addCar(name: String): RacingCar {
        racingCarValidation.validation(name)
        return RacingCar(name, INIT_DIST)
    }

    companion object {
        private const val INIT_DIST = ""
    }
}
