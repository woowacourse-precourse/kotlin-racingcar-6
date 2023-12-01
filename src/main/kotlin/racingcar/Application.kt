package racingcar

import racingcar.controller.GameController
import racingcar.model.RandomNumberMoveStrategy

fun main() {
    val gameController = GameController(RandomNumberMoveStrategy())
    gameController.start()

}
