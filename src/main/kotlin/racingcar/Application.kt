package racingcar

import org.junit.jupiter.api.parallel.Execution
const val result = "실행 결과"
const val winner = "최종 우승자 :"

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

private fun printProcess(cars: List<Car>){
    cars.forEach { car ->
        car.forwardCar()
        print("${car.name} : ${"-".repeat(car.forwardCount)}")
    }
    println()
}

private fun printResult(cars: List<Car>){
    val maxCount = cars.maxOf { it.forwardCount }
    val maxCar = cars.filter { it.forwardCount == maxCount }
    val maxCarNames = maxCar.joinToString(", ") { it.name }

    println("$winner $maxCarNames")
}

private fun playGame() {
    val cars: MutableList<Car> = makeCar()
    val executionNumber = InputManager.inputExecutionNumber()

    println(result)
    repeat(executionNumber) {
        printProcess(cars)
    }

    printResult(cars)
}

fun main() {
    playGame()
}
