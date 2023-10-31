package racingcar.domain

import racingcar.utils.Converter
import racingcar.utils.RandomGenerator

class Circuit(carNames: String, private var moveCount: Int) {
    private var cars = mutableListOf<Car>()

    init {
        createCarList(carNames)
    }

    fun startRace() {
        repeat(moveCount) {
            moveCarsAndPrintPositions()
        }
    }

    fun getCarList(): List<Car> {
        return cars.toList()
    }

    private fun createCarList(carNames: String) {
        val carNameList = Converter.splitByCommaToStringList(carNames)

        carNameList.forEach {
            val car = Car(it)
            cars.add(car)
        }
    }

    private fun moveCarsAndPrintPositions() {
        moveOrStayAllCars()
        printCarPositions()
    }

    private fun moveOrStayAllCars() {
        cars.forEach { it.moveOrStay(RandomGenerator.generateRandomNumber()) }
    }

    private fun printCarPositions() {
        cars.forEach { println(it) }
        println()
    }
}