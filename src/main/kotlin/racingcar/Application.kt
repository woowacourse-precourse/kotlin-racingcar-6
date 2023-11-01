package racingcar

import racingcar.Controller.CarController
import racingcar.Model.CarModel
import racingcar.View.CarView

fun main() {
    val view = CarView()
    val model = CarModel()
    val controller = CarController(view, model)
    controller.startGame()
}