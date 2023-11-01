package racingcar.domain

class Cars(private val cars: List<Car>) {

    private val stateOfGame = cars.associate { it.carName to it.score }.toMutableMap()
    fun moveCar(name: String) {
        stateOfGame[name] = stateOfGame[name]!! + 1
    }

    companion object {
        fun registerCars(userInput: String) {
            val carNames = userInput.split(",")
            val cars = carNames.map { Car(it) }
            Cars(cars)

            /**
             * 검증
             * 1. 5자 이하
             * 2. 중복 있는지
             */

        }
    }

}