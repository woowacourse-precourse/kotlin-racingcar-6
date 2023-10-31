package racingcar.round

import racingcar.car.Car

class RoundPlayer(private val cars: List<Car>) {
    fun play() {
        Movement(cars).moveCars()
        RoundResultPresenter(cars).showRoundResult()
    }
}