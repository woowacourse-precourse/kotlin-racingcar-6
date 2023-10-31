package racingcar

class RoundPlayer(private val cars: List<Car>) {
    fun play() {
        Movement(cars).moveCars()
        RoundResultPresenter(cars).showRoundResult()
    }
}