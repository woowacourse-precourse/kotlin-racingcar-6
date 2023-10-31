package racingcar.manager

import camp.nextstep.edu.missionutils.Console


class InputManager(private val validationManager: ValidationManager = ValidationManager()) {
    fun carNames(): List<String> =
        validationManager.getValidCarNames(Console.readLine()).split(",").map { it.trim() }

    fun attemptCount() = validationManager.getAttemptCount(Console.readLine())
}