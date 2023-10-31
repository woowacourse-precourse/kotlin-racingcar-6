package racingcar.view

import camp.nextstep.edu.missionutils.Console


class InputView {

    fun inputCars(): List<String> {
        val names = mutableListOf<String>()
        val carNames = Console.readLine().split(",")
        for (name in carNames) {
            InputValidator.validateName(name)
            names.add(name)
        }
        return names.toList()
    }

    fun inputAttempt(): Int {
        val attempt = Console.readLine()
        InputValidator.validateAttempt(attempt)
        return attempt.toInt()
    }
}