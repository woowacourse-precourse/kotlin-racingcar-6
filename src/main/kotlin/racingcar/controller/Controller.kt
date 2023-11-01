package racingcar.controller

import racingcar.car.Car
import racingcar.car.CarImpl
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
    }

    private fun getNamesOfCar(): List<String> {
        return InputView.askCarToRace(validator)
    }

    private fun setRacingCars(namesOfCar: List<String>) {
        for (name in namesOfCar) {
            cars.add(CarImpl(name))
        }
    }
}
