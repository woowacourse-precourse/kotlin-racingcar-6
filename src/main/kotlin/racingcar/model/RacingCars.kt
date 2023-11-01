package racingcar.model

class RacingCars(private val racingCars: List<RacingCar>) {

    fun getMaxDistanceCar(): List<RacingCar> {
        return racingCars.filter { racingCar -> racingCar.getDistance() == racingCars.maxOf { it.getDistance() } }
    }

}