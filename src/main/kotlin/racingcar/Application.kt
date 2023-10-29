package racingcar

import racingcar.controller.RaceController
import racingcar.view.ConsoleInputView
import racingcar.view.ConsoleOutputView
import racingcar.view.RaceView

fun main() {
    val view = RaceView(
        inputView = ConsoleInputView(),
        outputView = ConsoleOutputView()
    )

    val controller = RaceController(
        raceView = view
    )

    controller.startRace()
}
