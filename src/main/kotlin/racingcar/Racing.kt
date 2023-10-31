package racingcar

class Racing {
    private val cars: MutableList<Car> = mutableListOf()

    fun addCar(name: String) {
        if (name.length > 5) {
            throw IllegalArgumentException("자동차 이름은 5자 이하만 가능합니다.")
        }
        cars.add(Car(name))
    }

    fun gameCount(count: Int) {
        repeat(count) {
            cars.forEach { car -> car.move() }
        }
    }

    fun getWinner(): List<String> {
        val maxPosition = cars.maxOf { it.getPosition() }
        return cars.filter { it.getPosition() == maxPosition }.map { it.name }
    }
    fun getCars(): List<Car> {
        return cars
    }
}