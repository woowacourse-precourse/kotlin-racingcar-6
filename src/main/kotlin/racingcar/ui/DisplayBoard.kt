package racingcar.ui

import racingcar.domain.RacingCars
import racingcar.domain.Winners

class DisplayBoard {

    fun displayRaceStart() {
        println("실행 결과")
    }

    fun displayRacingResults(racingCars: RacingCars) {
        println(racingCars)
        println()
    }

    fun displayWinners(winners: Winners) {
        print(winners)
    }
}