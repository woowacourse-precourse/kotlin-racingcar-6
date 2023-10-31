package racingcar.model

class RaceParticipants private constructor(private val cars: List<Car>) {

    fun moveCar(carName: CarName) = cars.first { car -> car.name == carName }.moveForward()

    fun getDistance(carName: CarName): Int = cars.first { car -> car.name == carName }.distance

    fun getNamesOfParticipants(): List<CarName> = cars.map { car -> car.name }

    fun getCarsWithLongestDistance(): List<Car> {
        val maxDistance = cars.maxOfOrNull { car -> car.distance } ?: 0
        return cars.filter { car -> car.distance == maxDistance }
    }

    companion object {
        private const val NAME_SEPARATOR = ","

        fun from(carNames: String): RaceParticipants {
            val cars = carNames.split(NAME_SEPARATOR)
                .validateNoDuplicates()
                .getOrThrow()
                .map { name -> Car(CarName(name)) }
            return RaceParticipants(cars)
        }
    }
}