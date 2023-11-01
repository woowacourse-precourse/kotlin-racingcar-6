package racingcar.ui

import racingcar.domain.RacingCars
import racingcar.domain.Winners

class DisplayBoard {
    fun display(racingCars: RacingCars) {
        println(racingCars)
    }

    fun display(winners: Winners) {
        println(winners)
    }
}