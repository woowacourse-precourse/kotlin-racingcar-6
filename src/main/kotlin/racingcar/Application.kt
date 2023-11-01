package racingcar

import racingcar.controller.GameController
import racingcar.domain.CarNames
import racingcar.domain.MoveTimes
import racingcar.domain.RacingGame
import racingcar.io.Printer
import racingcar.io.Reader
import racingcar.utils.InputChecker
import racingcar.utils.RandomNumberGenerator
import racingcar.view.GameView

fun main() {
    val inputChecker = InputChecker()
    val carNames = CarNames(inputChecker)
    val moveTimes = MoveTimes(inputChecker)
    val racingGame = RacingGame(RandomNumberGenerator())
    val gameView = GameView(Printer(), Reader())
    val gameController = GameController(gameView, carNames, moveTimes, racingGame)

    gameController.run()
}
