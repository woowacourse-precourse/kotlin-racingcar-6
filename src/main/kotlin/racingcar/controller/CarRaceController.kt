package racingcar.controller

import racingcar.model.Car
import racingcar.util.Constants.ATTEMPT_NUMBER
import racingcar.util.Constants.CAR_RACE_NAME
import racingcar.util.Constants.RESULT
import racingcar.util.Validation.validateName
import racingcar.util.Validation.validateNum
import racingcar.view.CarRaceView
import kotlin.text.StringBuilder

class CarRaceController(val view: CarRaceView) {

    private val cars = mutableListOf<Car>()

    init {
        println(CAR_RACE_NAME)
    }

    fun run() {
        //이름 입력
        val carsName = view.inputCarName()
        validateName(carsName)

        //시도 횟수 입력
        println(ATTEMPT_NUMBER)
        val attemptNum = view.inputAttemptNumber()
        validateNum(attemptNum)
        println()

        //결과 출력
        println(RESULT)
        addCars(carsName)
        showCarRace(attemptNum.toInt())

        //최종 우승자 출력
        val winner = choiceWinner(cars)
        view.outputWinner(changeListToStr(winner))

    }

    private fun addCars(inputs: List<String>) {
        for (element in inputs) {
            cars.add(Car(element, 0))
        }
    }

    private fun showCarRace(attemptNum: Int) {
        for (idx in 0 until attemptNum) {
            for (car in cars) {
                car.goOrStop()
            }

            cars.forEach {
                print("${it.name} : ")
                view.outputCarsPosition(it.position)
            }
            println()
        }
    }

    //우승자 선별
    fun choiceWinner(cars: List<Car>): List<String> {
        val winner = mutableListOf<String>()

        val firstCar = cars.maxBy { it.position }
        for (car in cars) {
            if (firstCar.position == car.position) winner.add(car.name)
        }

        return winner
    }

    //문자열 변환
    fun changeListToStr(list: List<String>): String {
        return list.joinToString(", ")
    }
}