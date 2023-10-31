package racingcar.view

import racingcar.model.Cars

class OutputView {
    companion object {
        private const val RUN_RESULT = "실행 결과"
    }

    fun printHeadResult() {
        println(RUN_RESULT)
    }

    fun displayCarScores(cars: List<Cars>) {
        for (car in cars) {
            printCarNameAndPosition(car)
        }
        println()
    }

    private fun printCarNameAndPosition(cars: Cars) {
        println(cars.joinNameAndPosition())
    }

    private fun findMaxRacePosition(cars: List<Cars>): Int? {
        return cars.maxOfOrNull { it.carPosition }
    }

    fun displayRaceWinners(cars: List<Cars>) {
        val maxPosition = findMaxRacePosition(cars)
        if (maxPosition != null) {
            val winners = cars.filter { it.carPosition == maxPosition }
            println("최종 우승자 : ${winners.joinToString(", ") { it.carName }}")
        }
    }
}