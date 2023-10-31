package racingcar

class Game(
    private val gameInitializer: GameInitializer = GameInitializer(),
    private val gameMatch: GameMatch = GameMatch(),
    private val gameResultPresenter: GameResultPresenter = GameResultPresenter()
) {
    private val cars: Cars = Cars()
    private var round: Round = Round()

    fun start() {
        gameInitializer.init(cars, round)
        gameMatch.start(cars, round)
        gameResultPresenter.showWinners(cars)
    }
}