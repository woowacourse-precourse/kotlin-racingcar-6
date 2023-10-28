package racingcar.domain

class RacingCars(nameList: List<String>) {
    private val racingCars = mutableListOf<RacingCar>()

    init {
        validateNameListSize(nameList)
        validateNameLength(nameList)
        nameList.forEach {
            racingCars.add(RacingCar(it))
        }
    }

    fun loadRacingCars() = racingCars

    companion object {
        private const val MAX_NAME_LENGTH = 5
        private const val MIN_RACING_CAR_COUNT = 2
    }
}