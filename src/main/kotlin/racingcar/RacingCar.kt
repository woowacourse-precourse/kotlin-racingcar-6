package racingcar

import camp.nextstep.edu.missionutils.Randoms

class RacingCar(val name: String, var distance: Int) {
    fun move() {
        val randomNumber = Randoms.pickNumberInRange(0, 9)
        if(randomNumber >= 4) distance += 1
    }
}