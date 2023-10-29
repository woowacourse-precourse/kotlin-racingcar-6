package racingcar.controller

import camp.nextstep.edu.missionutils.Randoms
import racingcar.model.Car
import racingcar.view.ScreenView


class GameController (private val view: ScreenView){
    fun goOrNot(gameCount: Int, car: Car){
        var currentCount: Int = 0
        while (currentCount < gameCount) {
            val randomNumber = Randoms.pickNumberInRange(0, 9)
            if (randomNumber >= 4) {
                car.moved()
            }
            currentCount++
        }
    }


}