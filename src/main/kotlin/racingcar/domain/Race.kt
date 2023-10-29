package racingcar.domain

import racingcar.utils.Converter

class Race(carNames: String, private var moveCount: Int) {
    private var carList = mutableListOf<Car>()
    private var maxDistance = 0

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
        getMaxdistance()
        println("최종 우승자 : " + getWinnerCarNames().joinToString(", "))
    }

    fun getWinnerCarNames(): MutableList<String> {
        val winnerNames = mutableListOf<String>()

        for (car in carList) {
            if (car.isWinnerCar(maxDistance)) {
                winnerNames.add(car.getName())
            }
        }
        return winnerNames
    }

    private fun getMaxdistance() {
        var maxDistance = 0
        carList.forEach {
            if (it.getPosition() > maxDistance) {
                maxDistance = it.getPosition()
            }
        }
        this.maxDistance = maxDistance
    }

    private fun moveOrStayAllCars() {
        carList.forEach { it.moveOrStay() }
    }

    private fun printCarPositions() {
        carList.forEach { it.showCurrentPositionWithName() }
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