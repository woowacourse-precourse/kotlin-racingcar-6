package racingcar

class Game {
    private val gameInitializer = GameInitializer()

    private val cars: Cars = Cars()
    private var round: Round = Round()

    fun start() {
        gameInitializer.init(cars, round)
        matchStart()
        showWinners()
    }

    private fun matchStart() {
        println(MATCH_RESULT)
        repeat(round.getRound()) { cars.showRoundResult() }
    }

    private fun showWinners() {
        print(WINNER_INFO)
        cars.showWinners()
    }

    companion object {
        const val MATCH_RESULT = "실행 결과"
        const val WINNER_INFO = "최종 우승자 : "
    }
}