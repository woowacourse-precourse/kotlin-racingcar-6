package racingcar.controller

import racingcar.domain.game.RacingCarGame
import racingcar.view.InputView

object RacingCarGameController {
    fun start() {
        val carNames = InputView.readNames()
        val carMap = carNames.names.associateWithTo(mutableMapOf()) { 0 }
        val count = InputView.readCount()

        val racingCarGame = RacingCarGame(carMap)
        racingCarGame.play(count)
    }
}
