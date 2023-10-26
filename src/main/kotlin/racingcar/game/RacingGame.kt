package racingcar.game

class RacingGame {
    private lateinit var racingCars: MutableList<Car>
    fun start() {
        // TODO : startGame 메서드 구현
    }

    private fun inviteRacer(n: Int) {
        racingCars = mutableListOf()
        repeat(n) {
            racingCars.add(Car())
        }
    }
}