package racingcar.controller

import racingcar.util.Constants.CAR_RACE_NAME
import racingcar.util.Validation.validateName
import racingcar.view.CarRaceView

class CarRaceController(val view : CarRaceView) {

    init{
        println(CAR_RACE_NAME)
    }

    fun run(){
        val cars = view.inputCarName()
        validateName(cars)
    }
}