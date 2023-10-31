package racingcar

import racingcar.car.Cars
import racingcar.result.GameResult
import racingcar.round.Round
import racingcar.round.RoundMatch

class Game(
    private val gameInitializer: GameInitializer = GameInitializer(),
    private val roundMatch: RoundMatch = RoundMatch(),
    private val gameResult: GameResult = GameResult()
) {
    private val cars: Cars = Cars()
    private var round: Round = Round()

    fun start() {
        gameInitializer.init(cars, round)
        roundMatch.start(cars, round)
        gameResult.showWinners(cars)
    }
}