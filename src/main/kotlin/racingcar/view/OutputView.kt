package racingcar.view

import racingcar.model.Car
import racingcar.view.Constants.COMMA_DELIMITERS

class OutputView {
    fun printRoundResult(carList: List<Car>) {
        for (currentCar in carList) {
            println("${currentCar.name} : ${DASH.repeat(currentCar.score)}")
        }
        println()
    }

    fun printWinner(winnerList: List<String>) {
        println(
            "$FINAL_WINNER ${winnerList.joinToString("${COMMA_DELIMITERS} ")}"
        )
    }

    companion object {
        private const val DASH = "-"
        private const val FINAL_WINNER = "최종 우승자 :"
    }
}