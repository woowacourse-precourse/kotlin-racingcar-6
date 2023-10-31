package racingcar.model

private const val DUPLICATE_NAME_EXCEPTION_MESSAGE = "중복된 이름이 존재합니다!"
class Cars(private val cars: List<Car>) {

    init {
        val distinctByName = cars.distinctBy { it.name.value }
        require(cars.size == distinctByName.size) { DUPLICATE_NAME_EXCEPTION_MESSAGE }
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