package racingcar

private fun makeCar(): MutableList<Car> {
    val carsString = InputManager.inputCar()
    val limitChar = ","

    val carString: List<String> = carsString.split(limitChar)
    ExceptionManager.carException(carString)

    val car = mutableListOf<Car>()
    for (i in 0..carString.lastIndex) {
        car.add(Car(carString[i]))
    }
    return car
}

private fun playGame() {
    val car: MutableList<Car> = makeCar()
    car.map { println(it.name) }
}

fun main() {
    playGame()
}
