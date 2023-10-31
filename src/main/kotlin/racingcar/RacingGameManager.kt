package racingcar
object RacingGameManager {
    private lateinit var racingGame: RacingGame
    private var racingGameTotalRounds = 0

    fun startGame() {
        setUpGame()

        println("실행 결과")
        while (!isGameOver()) {
            racingGame.initRound()
        }

        endGame()
    }

    private fun setUpGame() {
        racingGame = RacingGame(carList = InputHandler.getCarName())
        racingGameTotalRounds = InputHandler.getAmount()
    }

    private fun endGame() {
        print("최종 우승자 : ${racingGame.getWinnerName().joinToString(", ")}")
    }

    private fun isGameOver() = racingGame.getCurrentGameRound() == racingGameTotalRounds

}