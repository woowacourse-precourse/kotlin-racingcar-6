package racingcar.container

import numbers.RandomNumberPicker
import racingcar.controller.GameController
import racingcar.domain.move.RandomMoveDecider
import racingcar.view.InputParser
import racingcar.view.InputValidator
import racingcar.view.InputView
import racingcar.view.OutputView

fun createGameController(): GameController {
    return GameController(
        InputView(
            InputValidator(),
            InputParser(),
        ),
        OutputView(),
        RandomMoveDecider(RandomNumberPicker()),
    )
}