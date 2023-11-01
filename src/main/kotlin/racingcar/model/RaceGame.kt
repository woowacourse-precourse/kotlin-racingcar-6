package racingcar.model

import camp.nextstep.edu.missionutils.Randoms

class RaceGame(carNames: String, private val numberOfRacing: Int) {
    private val carNameList: List<Car> = carNames.split(",").map { Car(it) }

    init {
        validateCarNames(carNames)
    }

    private fun validateCarNames(carNames: String) {
        if (carNameList.any { it.name.length > 5 }) {
            throw IllegalArgumentException("자동차 이름은 5자 이하 이어야 함")
        }
    }

    fun start() {
        runRaces()
        printWinners()
    }

    private fun runRaces() {
        for (i in 0 until numberOfRacing) {
            val randomNumArray = getRandomNumArray(carNameList)
            addScores(randomNumArray)
            printCarWithScores()
        }
    }

    private fun getRandomNumArray(carNamesList: List<Car>): List<Int> {
        return carNameList.map { Randoms.pickNumberInRange(0, 9) }
    }

    private fun addScores(randomNumArray: List<Int>) {
        for ((index, car) in carNameList.withIndex()) {
            if (randomNumArray[index] >= 4) {
                car.score++
            }
        }
    }

    private fun printCarWithScores() {
        for (car in carNameList) {
            val scoreLine = "-".repeat(car.score)
            println("${car.name} : $scoreLine")
        }
        println()
    }

    private fun printWinners() {
        val maxScore = carNameList.maxBy { it.score }?.score
        val winners = carNameList.filter { it.score == maxScore }.joinToString(", ") { it.name }
        println("최종 우승자 : $winners")
    }
}
