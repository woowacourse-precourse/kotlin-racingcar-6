package racingcar

import racingcar.controller.RaceController
import racingcar.view.ConsoleRaceView

fun main() {
    val controller = RaceController(
        raceView = ConsoleRaceView()
    )

    controller.startRace()
}
