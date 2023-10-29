package racingcar.model

class Cars(
    private val cars: List<Car>,
    private val moveStep: MoveStep = MoveStep
) {

    fun moveAllCars() {
        cars.forEach { car ->
            car.move(moveStep)
        }
    }

    fun getWinner(): List<Car> {
        val winnerCar = cars.maxBy { it.position }
        return cars.filter { it.position == winnerCar.position }
    }
}