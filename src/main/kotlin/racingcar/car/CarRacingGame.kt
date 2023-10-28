package racingcar.car

import racingcar.domain.Car
import racingcar.manager.InputManager
import racingcar.manager.OutputManager

class CarRacingGame(
    private val inputManager: InputManager = InputManager(),
    private val outputManager: OutputManager = OutputManager()
) {
    fun setUp(): Car {
        outputManager.racingCarNames()
        val carNames: List<String> = InputManager().carNames()

        outputManager.attemptCount()
        val attemptCount: Int = inputManager.attemptCount()

        outputManager.newLine()
        outputManager.racingResult()

        return Car(
            carNames = carNames,
            attemptCount = attemptCount
        )
    }
}