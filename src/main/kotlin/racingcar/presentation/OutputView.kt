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

    companion object {
        const val LINE_BREAK = "\n"
        const val RESULT_TITLE = "실행 결과"

        const val RESULT_FORMAT = "%s : %s"
        const val SCORE_MARK = "-"

        const val WINNER_TITLE = "최종 우승자 : "
        const val WINNER_FORMAT = ", "
    }
}