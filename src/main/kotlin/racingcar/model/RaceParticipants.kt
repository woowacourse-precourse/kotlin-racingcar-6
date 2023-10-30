package racingcar.model

class RaceParticipants private constructor(val cars: List<Car>) {

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
                .map { name -> Car(name) }
            return RaceParticipants(cars)
        }
    }
}