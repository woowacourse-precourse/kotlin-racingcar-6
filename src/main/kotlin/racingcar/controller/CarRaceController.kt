package racingcar.controller

import racingcar.util.Constants.ATTEMPT_NUMBER
import racingcar.util.Constants.CAR_RACE_NAME
import racingcar.util.Validation.validateName
import racingcar.util.Validation.validateNum
import racingcar.view.CarRaceView

class CarRaceController(val view : CarRaceView) {

    init{
        println(CAR_RACE_NAME)
    }

    fun run(){
        //이름 입력
        val cars = view.inputCarName()
        validateName(cars)

        //시도 횟수 입력
        println(ATTEMPT_NUMBER)
        val num = view.inputAttemptNumber()
        validateNum(num)

        //결과 출력


        //최종 우승자 출력

    }
}