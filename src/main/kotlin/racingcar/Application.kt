package racingcar

import race.CarController
import race.CarModel
import race.PrintResult

fun main() {
    run()
}

fun run() {
    val carModel = CarModel()
    val printResult = PrintResult()
    val carController = CarController(carModel,printResult)
    carController.runRace()
}