package racingcar

class CarGroup(carNames: String) {

    val cars: List<Car>

    init {
        val split = carNames.split(",")
        require(split.hasNoDuplicated()) { Error.Duplicated }
        cars = split.map { name -> Car(name) }
    }

    internal enum class Error(private val message: String) {
        Duplicated("이미 등록된 자동차예요. 다른 이름으로 입력해주세요.");

        override fun toString() = message
    }
}

fun <T> List<T>.hasNoDuplicated(): Boolean =
    this.toSet().size == this.size