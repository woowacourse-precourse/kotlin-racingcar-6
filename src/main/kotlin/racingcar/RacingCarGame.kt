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
        showTitle()
        while (currentRound != totalRound) {
            playRound()
            showRoundResult()
        }
        showWinners()
    }

    private fun showTitle() {
        racingCarGameViewer.showResultsTitle()
    }

    private fun playRound() {
        currentRound++

        racingCars.map { racingCar ->
            if (racingNumberGenerator.get() >= MIN_MOVING_NUMBER) racingCar.move()
        }
    }

    private fun showRoundResult() {
        racingCarGameViewer.showRoundResult(racingCars)
    }

    private fun showWinners() {
        racingCarGameViewer.showWinners(racingCars)
    }

    companion object {
        private const val MIN_MOVING_NUMBER = 4
    }
}