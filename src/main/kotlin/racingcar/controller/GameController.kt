package racingcar.controller

import racingcar.domain.CarNames

class GameController(
    private val carNames: CarNames
) {
    fun run() {
        carNames.inputCarNames()
    }
}