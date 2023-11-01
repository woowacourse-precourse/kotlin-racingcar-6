package racingcar

object GameRunner {
    fun run() {
        val raceManager = RaceManager()
        val racingGame = RacingGame(RacingCarInput, MoveCountInput, raceManager, RacePrinter)
        racingGame.start()
    }
}
