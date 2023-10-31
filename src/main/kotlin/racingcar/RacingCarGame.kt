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
            racingNumberGenerator.get()
        }
    }
}