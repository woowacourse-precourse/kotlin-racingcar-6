package racingcar

import racingcar.controllers.CarRaceController
import racingcar.models.CarRaceModel
import racingcar.views.CarRaceView

fun main() {
    val model = CarRaceModel()
    val view = CarRaceView()
    val controller = CarRaceController(model, view)
    controller.startRace()
}