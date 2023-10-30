package racingcar.view

import racingcar.domain.Cars

class OutputView {
    companion object {
        private const val RUN_RESULT = "실행 결과"
    }
    fun printHeadResult() {
        println(RUN_RESULT)
    }
    fun printScore(cars: List<Cars>) {
        for (car in cars) {
            printCarScore(car)
        }
        println()
    }

    private fun printCarScore(cars: Cars) {
        println(cars.joinNameAndPosition())
    }

    private fun racePointMax(cars: List<Cars>): Int? {
        return cars.maxOfOrNull { it.carPosition }
    }

    fun raceWinners(cars: List<Cars>) {
        val maxPosition = racePointMax(cars)
        if (maxPosition != null) {
            val winners = cars.filter { it.carPosition == maxPosition }
            println("최종 우승자 : ${winners.joinToString(", ") { it.carName }}")
        }
    }
}