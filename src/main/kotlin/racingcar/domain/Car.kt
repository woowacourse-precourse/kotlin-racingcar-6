package racingcar.domain

import racingcar.manager.InputManager
import racingcar.manager.OutputManager

class Car(
    private val carRace: CarRace = CarRace(),
    private val carNames: List<String>,
    private val attemptCount: Int
) {
    fun race() {
        carRace.racing (
            carNames = carNames,
            attemptCount = attemptCount
        )
    }
}