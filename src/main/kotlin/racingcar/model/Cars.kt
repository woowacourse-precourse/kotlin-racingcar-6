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
}