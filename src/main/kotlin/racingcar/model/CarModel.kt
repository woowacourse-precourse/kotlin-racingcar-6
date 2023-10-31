package racingcar.model

import racingcar.util.MOVE_CONDITION
import racingcar.validation.InputValidation

class CarModel {
    private var carNames: List<String> = emptyList()
    private var attemptsNumber: Int = 0

    fun setCarNames(names: List<String>) {
        carNames = InputValidation().validateCarNames(names)
    }

    fun setAttemptsNumber(attempts: String) {
        attemptsNumber = InputValidation().validateAttemptsNumber(attempts)
    }

    fun moveCar() {
        val randomNumber = RandomNumber()
        for (carName in carNames) {
            val random = randomNumber.randomNumberGenerator()
            if (random >= MOVE_CONDITION) {

            } else {

            }
        }
    }
}