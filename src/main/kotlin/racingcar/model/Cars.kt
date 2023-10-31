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

    fun getWinner(): List<String> {
        val winnerCar = cars.maxBy { it.position }
        val winnerCarList = cars.filter { it.position == winnerCar.position }
        return winnerCarList.map { it.name }
    }
}