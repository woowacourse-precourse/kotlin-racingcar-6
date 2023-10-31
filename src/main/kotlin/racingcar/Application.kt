package racingcar

import racingcar.View.InputView
import racingcar.View.OutputView

fun main() {
    val race = Race(InputView(), OutputView())
    race.run()
}