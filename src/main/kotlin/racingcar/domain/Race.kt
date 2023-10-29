package racingcar.domain

import racingcar.utils.Converter

class Race(carNames: String, private var moveCount: Int) {
    private var carList = mutableListOf<Car>()

    init {
        createCarList(carNames)
    }

    fun startRace() {
        while (moveCount > 0) {
            moveOrStayAllCars()
            moveCount--
        }
    }

    private fun moveOrStayAllCars() {
        carList.forEach { it.moveOrStay() }
    }

    private fun createCarList(carNames: String) {
        val carNameList = Converter.splitByCommaToStringList(carNames)

        carNameList.forEach {
            val car = Car(it)
            carList.add(car)
        }
    }
}