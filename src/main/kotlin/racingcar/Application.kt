package racingcar

import racingcar.controller.GameController
import racingcar.domain.CarNames
import racingcar.io.Printer
import racingcar.io.Reader
import racingcar.utils.InputChecker

fun main() {
    val gameController = GameController(CarNames(Reader(), Printer(), InputChecker()))

    gameController.run()
}
