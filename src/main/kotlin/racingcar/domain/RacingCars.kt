package racingcar.domain

class RacingCars(nameList: List<String>) {
    private val racingCars = mutableListOf<RacingCar>()

    init {
        nameList.forEach {
            racingCars.add(RacingCar(it))
        }
    }

    fun loadRacingCars() = racingCars
    
}