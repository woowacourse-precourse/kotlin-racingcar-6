package racingcar.view

import racingcar.model.RacingCar
import racingcar.model.WinnerGenerator

class OutputView {
    private val winnerGenerator = WinnerGenerator()
    fun printProgress(racingCars: MutableList<RacingCar>) {
        for (racingCar in racingCars) {
            println("${racingCar.name} : ${racingCar.distance}")
        }
        println()
    }

    fun gameResult(racingCars: MutableList<RacingCar>) {
        print("최종 우승자 : ")
        val winners = winnerGenerator.win(racingCars)
        println(winners.getWinners())
    }
}