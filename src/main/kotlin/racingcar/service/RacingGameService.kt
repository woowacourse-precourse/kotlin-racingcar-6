package racingcar.service

import racingcar.model.RacingGameModel
import racingcar.view.RacingGameView
import racingcar.controller.RacingGameController
class RacingGameService {
    private val model = RacingGameModel()
    private val view = RacingGameView()
    private val controller = RacingGameController(view = view, model = model)
    fun run() {
        controller.run()
    }
}