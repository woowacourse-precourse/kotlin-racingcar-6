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

private fun printProcess(car: MutableList<Car>){
    car.forEach {
        it.forwardCar()
        print("${it.name} : ")
        println("-".repeat(it.forwardCount))
    }
    println()
}

private fun printResult(car: MutableList<Car>){
    val maxCount = car.maxOf { it.forwardCount }
    val maxCar = car.filter { it.forwardCount == maxCount }
    val maxCarName = maxCar.map { it.name }
    val maxCarString = maxCarName.joinToString(", ")

//    val maxCarName = maxCar.name
    println("$winner $maxCarString")
}

private fun playGame() {
    val car: MutableList<Car> = makeCar()
    val executionNumber = InputManager.inputExecutionNumber()

    println(result)
    repeat(executionNumber) {
        printProcess(car)
    }

    printResult(car)
}

fun main() {
    playGame()
}
