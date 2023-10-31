package racingcar

import org.junit.jupiter.api.parallel.Execution
const val RESULT = "실행 결과"
const val WINNER = "최종 우승자 :"

private fun makeCar(): MutableList<Car> {
    val carString = InputManager.inputCar()

    val car = mutableListOf<Car>()
    for (i in 0..carString.lastIndex) {
        car.add(Car(carString[i]))
    }
    return car
}

private fun printProcess(cars: List<Car>){
    cars.forEach { car ->
        car.forwardCar()
        println("${car.name} : ${"-".repeat(car.forwardCount)}")
    }
    println()
}

private fun printResult(cars: List<Car>){
    val maxCount = cars.maxOf { it.forwardCount }
    val winners = cars.filter { it.forwardCount == maxCount }
    val winnerNames = winners.joinToString(", ") { it.name }

    println("$WINNER $winnerNames")
}

private fun playGame() {
    val cars: MutableList<Car> = makeCar()
    val executionNumber = InputManager.inputExecutionNumber()

    println(RESULT)
    repeat(executionNumber) {
        printProcess(cars)
    }

    printResult(cars)
}

fun main() {
    playGame()
}
