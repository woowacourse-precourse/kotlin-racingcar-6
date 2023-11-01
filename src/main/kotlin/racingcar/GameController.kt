package racingcar
import racingcar.model.GameModel

class GameController(private val view: GameView) {
    fun racingGame() {
        val carNames = view.getCarNames()
        val attempts = view.getAttempts()

        val racingGame = GameModel(carNames)
        repeat(attempts) {
            racingGame.race()
            view.raceStatus(racingGame.cars)
        }
        val winners = racingGame.getWinners()
        view.printWinner(winners)
    }
}