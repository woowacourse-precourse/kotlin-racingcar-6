package racingcar.domain

import racingcar.utils.StringListSplitter
import racingcar.utils.RandomGenerator

class Circuit(carNames: String, private var raceRound: Int) {
    private var cars = mutableListOf<Car>()

    init {
        registerCars(carNames)
    }

    fun startRace() {
        repeat(raceRound) {
            playRound()
            printRacingStatus()
        }
    }

    fun getCarList(): List<Car> {
        return cars.toList()
    }

    private fun registerCars(carNames: String) {
        val carNameList = StringListSplitter.splitByCommaToStringList(carNames)
        cars.addAll(carNameList.map { Car(it) })
    }

    private fun playRound() {
        cars.forEach { it.moveOrStay(RandomGenerator.generateRandomNumber()) }
    }

    private fun printRacingStatus() {
        cars.forEach { println(it) }
        println()
    }
}