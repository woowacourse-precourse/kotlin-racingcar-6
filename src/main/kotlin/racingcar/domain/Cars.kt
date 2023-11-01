package racingcar.domain

class Cars(private val cars: List<Car>) {

    private val stateOfGame = cars.associate { it.carName to it.forward }.toMutableMap()
    fun moveCar(name: String) {
        stateOfGame[name] = stateOfGame[name]!! + 1
    }

    companion object {
        fun registerCars(userInput: String) {
            val carNames = userInput.split(",")
            val cars = carNames.map { Car(it) }
            Cars(cars)
        }
    }

}