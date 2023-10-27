package racingcar.manager

import camp.nextstep.edu.missionutils.Console.readLine


class InputManager(private val validationManager: ValidationManager) {
    fun carNames(): List<String> =
        validationManager.getValidCarNames(readLine()).split(",").map { it.trim() }
}