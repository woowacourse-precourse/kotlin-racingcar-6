package racingcar

class RacingCarGame {
    private val racingCarGameManager = RacingCarGameManager()
    private val racingNumberGenerator = RacingNumberGenerator()
    private val racingCarGameViewer = RacingCarGameViewer()
    private var racingCars = listOf<RacingCar>()
    private var totalRound = 0
    private var currentRound = 0

    init {
        racingCarGameManager.setConfiguration()
        this.racingCars = racingCarGameManager.getRacingCars()
        this.totalRound = racingCarGameManager.getTotalRound()
    }

    fun run() {
        playRound()
    }

    private fun playRound() {
        racingCars.map { racingCar ->
            if (racingNumberGenerator.get() >= MIN_MOVING_NUMBER) racingCar.move()
            racingCarGameViewer.showMoveResult(racingCar)
        }
    }

    companion object {
        private const val MIN_MOVING_NUMBER = 4
    }
}