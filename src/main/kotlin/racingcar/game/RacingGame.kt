package racingcar.game

class RacingGame {
    private lateinit var racingCars: List<Car>

    fun start() {
        inviteRacer()
    }

    private fun inviteRacer() {
        racingCars = UserInput.getRacingCars()
    }
}