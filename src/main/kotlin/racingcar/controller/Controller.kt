package racingcar.controller

import racingcar.car.Car
import racingcar.car.CarImpl
import racingcar.randomnumbergenerator.RandomNumberGenerator
import racingcar.validator.Validator
import racingcar.view.InputView
import racingcar.view.OutputView

class Controller(
    private val validator: Validator,
) {
    private val cars = ArrayList<Car>()

    fun startGame() {
        OutputView.enterNamesOfCars()
        setRacingCars(getNamesOfCar())
        OutputView.howManyAttempts()
        val attempt = getAttempts()
        OutputView.executionResult()
    }

    private fun getNamesOfCar(): List<String> {
        return InputView.askCarToRace(validator)
    }

    private fun setRacingCars(namesOfCar: List<String>) {
        for (name in namesOfCar) {
            cars.add(CarImpl(name))
        }
    }

    private fun getAttempts(): Int {
        return InputView.askNumberOfAttempts(validator)
    }
}
