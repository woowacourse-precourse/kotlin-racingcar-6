package racingcar.domain

import racingcar.utils.RandomGenerator
import racingcar.utils.StringListSplitter

class Circuit(carNames: String, private val raceRound: Int) {
    private val cars = mutableListOf<Car>()

    init {
        val carNameList = StringListSplitter.splitByCommaToStringList(carNames)
        registerCars(carNameList)
    }

    private fun registerCars(carNameList: List<String>) {
        cars.addAll(carNameList.map { Car(it) })
    }

    fun startRace() {
        repeat(raceRound) {
            playRound()
            printRacingStatus()
        }
    }

    private fun playRound() {
        cars.forEach { it.moveOrStay(RandomGenerator.generateRandomNumber()) }
    }

    private fun printRacingStatus() {
        cars.forEach { println(it) }
        println()
    }

    fun getCarList(): List<Car> {
        return cars.toList()
    }
}