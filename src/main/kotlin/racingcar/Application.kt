package racingcar

import racingcar.domain.GameHandler
import racingcar.domain.IOHandler
import racingcar.domain.Analyzer
import racingcar.domain.Validator

fun main() {
    val validator = Validator()
    val ioHandler = IOHandler(validator)
    val analyzer = Analyzer()
    val gameHandler = GameHandler(ioHandler, analyzer)

    gameHandler.start()
}