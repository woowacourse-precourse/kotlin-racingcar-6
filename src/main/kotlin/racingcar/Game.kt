package racingcar

class Game {
    private val gameInitializer = GameInitializer()
    private val gameMatch = GameMatch()

    private val cars: Cars = Cars()
    private var round: Round = Round()

    fun start() {
        gameInitializer.init(cars, round)
        gameMatch.start(cars, round)
        showWinners()
    }

    private fun showWinners() {
        print(WINNER_INFO)
        cars.showWinners()
    }

    companion object {
        const val WINNER_INFO = "최종 우승자 : "
    }
}