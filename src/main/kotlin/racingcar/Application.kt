package racingcar

import racingcar.Controller.CarController
import racingcar.View.CarView

fun main() {
    val view = CarView()
    val controller = CarController(view)
    controller.startGame()
}