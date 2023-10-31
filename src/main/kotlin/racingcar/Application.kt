package racingcar

import Race
import racingcar.View.InputView
import racingcar.View.OutputView

fun main() {
    val race = Race(InputView(), OutputView())
    race.run()
}