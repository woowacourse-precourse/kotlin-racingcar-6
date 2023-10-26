package racingcar.domain

class RacingCars(private val nameList: List<String>) {
    private val racingCars = mutableListOf<RacingCar>()

    init {
        nameList.forEach {
            racingCars.add(RacingCar(it))
        }
    }
}