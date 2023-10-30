package racingcar

import racingcar.controller.GameController
import racingcar.domain.CarNames
import racingcar.domain.MoveTimes
import racingcar.io.Printer
import racingcar.io.Reader
import racingcar.utils.InputChecker

fun main() {
    val reader = Reader()
    val printer = Printer()
    val inputChecker = InputChecker()
    val carNames = CarNames(reader, printer, inputChecker)
    val moveTimes = MoveTimes(reader, printer, inputChecker)
    val gameController = GameController(carNames, moveTimes)

    gameController.run()
}
