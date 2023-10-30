package racingcar.domain

import racingcar.utils.Converter
import racingcar.utils.RandomGenerator

class Circuit(carNames: String, private var moveCount: Int) {
    private var carList = mutableListOf<Car>()

    init {
        createCarList(carNames)
    }

    fun startRace() {
        repeat(moveCount) {
            moveCarsAndPrintPositions()
        }
    }

    fun getCarList(): MutableList<Car> {
        return carList
    }

    private fun createCarList(carNames: String) {
        val carNameList = Converter.splitByCommaToStringList(carNames)

        carNameList.forEach {
            val car = Car(it)
            carList.add(car)
        }
    }

    private fun moveCarsAndPrintPositions() {
        moveOrStayAllCars()
        printCarPositions()
    }

    private fun moveOrStayAllCars() {
        carList.forEach { it.moveOrStay(RandomGenerator.generateRandomNumber()) }
    }

    private fun printCarPositions() {
        carList.forEach { println(it) }
        println()
    }
}