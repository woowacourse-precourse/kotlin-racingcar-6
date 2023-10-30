package racingcar.model

class Cars(private val cars: List<Car>) {

    init {
        require(cars.size == cars.toSet().size) { "중복된 이름이 존재합니다!" }
    }

    fun raceCars() {
        cars.forEach { car ->
            Move.moveOrStay(car)
        }
    }

    fun getWinners(): List<Car> {
        val maxPosition = cars.maxBy(Car::position).position
        return findWinners(maxPosition)
    }

    private fun findWinners(maxPosition: Int): List<Car> {
        return cars.filter { it.position == maxPosition }
    }

    // 읽기 전용 불변 리스트로 반환
    fun getCars() = cars
}