package racingcar
import racingcar.model.CarModel
import racingcar.model.GameModel

class GameController(private val view: GameView, private val racingGame: GameModel) {
    fun racingGame() {
        val carNames = view.getCarNames()
        val attempts = view.getAttempts()

        val cars: List<CarModel> = carNames.map { CarModel(it) }

        repeat(attempts) {
            racingGame.race(cars)
            view.raceStatus(cars)
        }

        val winners = racingGame.getWinners(cars)
        view.printWinner(winners)
    }
}