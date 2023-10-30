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

    val cars = mutableListOf<Car>()

    init {
        println(CAR_RACE_NAME)
    }

    fun run() {
        //이름 입력
        val carsName = view.inputCarName()
        validateName(carsName)

        //시도 횟수 입력
        println(ATTEMPT_NUMBER)
        val num = view.inputAttemptNumber()
        validateNum(num)
        println()

        //결과 출력
        println(RESULT)
        for (idx in 0 until carsName.size) {
            cars.add(Car(carsName[idx], 0))
        }

        for (idx in 0 until num.toInt()) {
            for(car in cars){
                car.goOrStop()
            }

            cars.forEach {
                print("${it.name} : ")
                println(showCars(it.position))
            }
            println()
        }

        //최종 우승자 출력


    }
    fun showCars(position : Int) : String{
        val sb = StringBuilder()
        repeat(position){
            sb.append("-")
        }
        return sb.toString()
    }
}