package racingcar.controller

import racingcar.model.Car
import racingcar.util.Constants.ATTEMPT_NUMBER
import racingcar.util.Constants.CAR_RACE_NAME
import racingcar.util.Constants.RESULT
import racingcar.util.Validation.validateName
import racingcar.util.Validation.validateNum
import racingcar.view.CarRaceView
import kotlin.text.StringBuilder

class CarRaceController(private val view: CarRaceView) {

    private val cars = mutableListOf<Car>()

    init {
        println(CAR_RACE_NAME)
    }

    fun run() {
        val carsName = view.inputCarName()

        println(ATTEMPT_NUMBER)
        val attemptNum = view.inputAttemptNumber()
        println()

        println(RESULT)
        addCars(carsName)
        showRaceResult(attemptNum.toInt())

        val winner = choiceWinner(cars)
        view.outputWinner(changeListToStr(winner))

    }

    private fun addCars(inputs: List<String>) {
        for (element in inputs) {
            cars.add(Car(element, 0))
        }
    }

    private fun showRaceResult(attemptNum: Int) {
        repeat(attemptNum) {
            for (car in cars) {
                car.goOrStop()
                print("${car.name} : ")
                view.outputCarsPosition(car.position)
            }

            println()
        }
    }

    fun choiceWinner(cars: List<Car>): List<String> {
        val winner = mutableListOf<String>()

        val firstCar = cars.maxBy { it.position }
        for (car in cars) {
            if (firstCar.position == car.position) winner.add(car.name)
        }

        return winner
    }

    fun changeListToStr(list: List<String>): String {
        return list.joinToString(", ")
    }
}