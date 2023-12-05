package racingcar.presentation

import racingcar.domain.CarName
import racingcar.domain.CarsScore

class OutputView {
    fun printResultTitle() = println(LINE_BREAK + RESULT_TITLE)

    fun printEachRoundResult(carsScore: CarsScore) {
        carsScore.forEach { (car, score) ->
            println(RESULT_FORMAT.format(car.name, SCORE_MARK.repeat(score)))
        }
        print(LINE_BREAK)
    }

    fun printWinner(winner: List<CarName>) {
        print(WINNER_TITLE)
        print(winner.joinToString(WINNER_FORMAT))
    }

    fun printError(e: IllegalArgumentException) =
        println(e.message + LINE_BREAK)

    companion object {
        private const val LINE_BREAK = "\n"
        private const val RESULT_TITLE = "실행 결과"

        private const val RESULT_FORMAT = "%s : %s"
        private const val SCORE_MARK = "-"

        private const val WINNER_TITLE = "최종 우승자 : "
        private const val WINNER_FORMAT = ", "

//        private const val ERROR = "[ERROR] "
    }
}