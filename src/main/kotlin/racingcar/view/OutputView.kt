package racingcar.view

import racingcar.model.Car
import racingcar.model.Cars

class OutputView {

    fun showResultHeader() = println(TRY_RESULT_HEADER)

    fun showTryResult(cars: Cars) {
        cars.cars.forEach {
            println("${it.name} : " + "-".repeat(it.position))
        }
        println()
    }

    fun showTotalWinner(winners: List<Car>) {
        print(TOTAL_WINNER_GUIDE)
        repeat(winners.size - 1) {
            print("${winners[it].name}, ")
        }
        println(winners.last().name)
    }

    companion object {
        const val TRY_RESULT_HEADER = "실행 결과"
        const val TOTAL_WINNER_GUIDE = "최종 우승자 : "
    }
}