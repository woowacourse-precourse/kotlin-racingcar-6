package racingcar

import racingcar.domain.GameHandler
import racingcar.domain.IOHandler
import racingcar.domain.Analyzer
import racingcar.domain.Validator

fun main() {
    val ioHandler = IOHandler(Validator())
    val analyzer = Analyzer()
    val gameHandler = GameHandler(ioHandler, analyzer)

    gameHandler.start()
}
