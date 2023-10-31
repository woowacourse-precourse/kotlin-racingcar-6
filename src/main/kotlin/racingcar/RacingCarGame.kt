package racingcar

class RacingCarGame {
    private val racingCarGameManager = RacingCarGameManager()
    private val racingNumberGenerator = RacingNumberGenerator()
    private var currentRound = 0

    init {
        racingCarGameManager.setConfiguration()
    }

    fun run() {

    }

    private fun playRound() {
        racingCarGameManager.getRacingCars().map { racingCar ->
            if (racingNumberGenerator.get() >= MIN_MOVING_NUMBER) racingCar.move()
        }
    }

    companion object {
        private const val MIN_MOVING_NUMBER = 4
    }
}