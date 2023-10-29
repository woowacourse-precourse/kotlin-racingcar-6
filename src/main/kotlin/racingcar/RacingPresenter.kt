package racingcar

class RacingPresenter {

    private val _racingCars = mutableListOf<RacingCar>()
    private val racingCars: List<RacingCar> get() = _racingCars

    fun createRacingCarsOrThrow(rawInput: String) {
        val names = rawInput.split(",")
        names.forEach {
            val car = RacingCar.createOrThrow(it)
            _racingCars.add(car)
        }
    }
}