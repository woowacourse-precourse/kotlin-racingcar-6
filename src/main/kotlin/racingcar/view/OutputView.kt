package racingcar.view

import racingcar.model.Car
import racingcar.view.Constants.COMMA_DELIMITERS

class OutputView {
    internal fun printResultInfo() = println("\n$EXECUTION_RESULT_TEXT")

    internal fun printRoundResult(carList: List<Car>) {
        for (currentCar in carList) {
            println("${currentCar.name} : ${DASH.repeat(currentCar.score)}")
        }
        println()
    }

    internal fun printWinner(winnerList: List<String>) =
        print("$FINAL_WINNER ${winnerList.joinToString("${COMMA_DELIMITERS} ")}")


    companion object {
        private const val DASH = "-"
        private const val EXECUTION_RESULT_TEXT = "실행 결과"
        private const val FINAL_WINNER = "최종 우승자 :"
    }
}