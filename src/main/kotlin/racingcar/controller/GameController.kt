package racingcar.controller

import racingcar.domain.CarNames
import racingcar.domain.MoveTimes

class GameController(
    private val carNames: CarNames,
    private val moveTimes: MoveTimes
) {
    fun run() {
        carNames.inputCarNames()
        moveTimes.inputMoveTimes()
    }
}