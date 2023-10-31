package racingcar.model

class Cars(val cars: List<Car>) {

    fun decideWinner(): List<String> {
        val maxPosition = cars.maxOf(Car::position)
        return cars.filter {
            it.position == maxPosition
        }.map { it.name }.toList()
    }

    fun validate() {
        validateDuplicate()
        cars.forEach(Car::validateCar)
    }

    internal fun validateDuplicate() {
        val set = cars.map(Car::name).toSet()
        if (cars.size > set.size) {
            throw IllegalArgumentException("차에 중복된 이름이 있습니다.")
        }
    }

}