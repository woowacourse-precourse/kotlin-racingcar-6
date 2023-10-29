package racingcar.domain

import racingcar.utils.Converter

class Race(carNames: String, private var moveCount: Int) {
    private var carList = mutableListOf<Car>()

    init {
        createCarList(carNames)
    }

    fun startRace() {
        println()
        println("실행 결과")

        while (moveCount > 0) {
            moveOrStayAllCars()
            printCarPositions()
            moveCount--
        }
    }

    private fun moveOrStayAllCars() {
        carList.forEach { it.moveOrStay() }
    }

    private fun printCarPositions() {
        carList.forEach {it.showCurrentPositionWithName()}
        println()
    }

    private fun createCarList(carNames: String) {
        val carNameList = Converter.splitByCommaToStringList(carNames)

        carNameList.forEach {
            val car = Car(it)
            carList.add(car)
        }
    }
}