package racingcar.model

import racingcar.validation.InputValidation

class CarModel {
    private var carNames: List<String> = emptyList()

    fun setCarNames(names: List<String>) {
        carNames = InputValidation().validateCarNames(names)
    }
}