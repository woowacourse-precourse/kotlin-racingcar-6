package racingcar

import org.junit.jupiter.api.parallel.Execution
const val result = "실행 결과"

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

private fun printResult(car: MutableList<Car>){
    car.map {
        it.forwardCar()
        print("${it.name} : ")
        println("-".repeat(it.forwardCount))
    }
    println()
}

private fun playGame() {
    val car: MutableList<Car> = makeCar()
    val executionNumber = InputManager.inputExecutionNumber()

    println(result)
    repeat(executionNumber) {
        printResult(car)
    }

}

fun main() {
    playGame()
}
