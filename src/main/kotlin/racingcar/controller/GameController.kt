package racingcar.controller

import racingcar.model.Car
import racingcar.model.Cars
import racingcar.view.InputCars
import racingcar.view.InputTry
import racingcar.view.OutputGuide

class GameController {
    private val outputGuide = OutputGuide()
    private val inputCars = InputCars()
    private val inputTry = InputTry()
    private lateinit var cars: Cars
    fun startGame() {
        outputGuide.showStartGuide()
        cars = Cars(inputCars().map { Car(it) })
        outputGuide.showTryCountGuide()
        val tryCount = inputTry()

    }

    fun startTurn(tryCount: Int) {

    }


}