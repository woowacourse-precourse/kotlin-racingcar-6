package racingcar.round

import racingcar.car.Car

class RoundPlayer(private val cars: List<Car>) {
    fun play() {
        Movement(cars).moveCars()
        RoundResult(cars).showRoundResult()
    }
}