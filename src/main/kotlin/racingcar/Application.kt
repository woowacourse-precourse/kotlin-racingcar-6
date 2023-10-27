package racingcar

import racingcar.manager.InputManager
import racingcar.manager.ValidationManager

fun main() {
    InputManager().apply {
        carNames()
        attemptCount()
    }
}
