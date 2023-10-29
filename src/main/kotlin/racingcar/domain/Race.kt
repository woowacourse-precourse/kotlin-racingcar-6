package racingcar.domain

import racingcar.utils.Converter

class Race(carNames: String) {
    private var carList = mutableListOf<Car>()

    init {
        createCarList(carNames)
    }

    private fun createCarList(carNames: String) {
        val carNameList = Converter.splitByCommaToStringList(carNames)

        carNameList.forEach{
            val car = Car(it)
            carList.add(car)
        }
    }
}