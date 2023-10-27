package racingcar.domain

import racingcar.manager.InputManager
import racingcar.manager.OutputManager

class Car(
    private val inputManager: InputManager = InputManager(),
    private val outputManager: OutputManager = OutputManager(),
    private val carRace: CarRace = CarRace()
) {
    private val carNames: List<String> by lazy { inputManager.carNames() }
    private val attemptCount: Int by lazy { inputManager.attemptCount() }

    fun race() {
        carRace.race(
            carNames = carNames,
            attemptCount = attemptCount
        )
    }

    init {
        outputManager.racingCarNames()
        carNames
        outputManager.attemptCount()
        attemptCount
        outputManager.newLine()
        outputManager.racingResult()
    }
}