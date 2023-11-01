package racingcar

import racingcar.controller.CarRaceController
import racingcar.view.CarRaceView

fun main() {
    val carRaceController = CarRaceController(CarRaceView())
    carRaceController.run()
}
