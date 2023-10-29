package racingcar.model

class CarGroup private constructor(val cars: List<Car>) {

    fun getCarsWithLongestDistance(): List<Car> {
        val maxDistance = cars.maxOfOrNull { car -> car.distance } ?: 0
        return cars.filter { car -> car.distance == maxDistance }
    }

    internal enum class Error(private val message: String) {
        Duplicated("이미 등록된 자동차예요. 다른 이름으로 입력해주세요.");

        override fun toString() = message
    }

    companion object {
        private const val NAME_SEPARATOR = ","

        fun from(carNames: String): CarGroup {
            val split = carNames.split(NAME_SEPARATOR)
            require(split.hasNoDuplicated()) { Error.Duplicated }
            val cars = split.map { name -> Car(name) }
            return CarGroup(cars)
        }
    }
}

fun <T> List<T>.hasNoDuplicated(): Boolean =
    this.toSet().size == this.size