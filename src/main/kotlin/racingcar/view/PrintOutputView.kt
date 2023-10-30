package racingcar.view

import racingcar.constant.PrintText
import racingcar.domain.RacingCars
import racingcar.domain.RacingGameWinners

class PrintOutputView {

    fun printRequireCarNames() {
        println(PrintText.REQUIRE_CAR_NAMES.text)
    }

    fun printRequireAttemptCount() {
        println(PrintText.REQUIRE_ATTEMPT_COUNT.text)
    }

    fun printAttemptResult(racingCars: RacingCars) {
        val attemptResult = racingCars.toRacingCarsAttemptResult()
        println(attemptResult)
    }

    fun printWinner(gameWinner: RacingGameWinners) {
        print(PrintText.PRINT_WINNER.text)
        val winners = gameWinner.toWinnerNamesGameResult()
        println(winners)
    }

}