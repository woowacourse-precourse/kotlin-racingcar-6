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
        for (racingCar in racingCars.loadRacingCars()) {
            print(racingCar.readRacingCarName() + PrintText.SEPARATE_CAR_NAME_AND_FORWARD_COUNT.text)
            for (count in 0 until racingCar.receiveForwardCount()) {
                print(PrintText.PRINT_FORWARD_MARK.text)
            }
            println()
        }
        println()
    }

    fun printSoleWinner(gameWinner: RacingGameWinners) {
        println(PrintText.PRINT_WINNER.text + gameWinner.getWinners().first().toString())
    }

    fun printJointWinner(gameWinner: RacingGameWinners) {
        print(PrintText.PRINT_WINNER.text)
        for (i in 0 until gameWinner.getWinners().size - 1) {
            print(gameWinner.getWinners()[i] + PrintText.SEPARATE_WINNER.text)
        }
        println(gameWinner.getWinners().last())
    }
}