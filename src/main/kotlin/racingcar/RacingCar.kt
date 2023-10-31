package racingcar

import camp.nextstep.edu.missionutils.Randoms

class RacingCar(val name: String) {
    var mileage = 0

    fun move() {
        if (Randoms.pickNumberInRange(0, 9) >= 4) {
            mileage++
        }
    }

    fun print() {
        TODO("Not yet implemented")
    }

}
