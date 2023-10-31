package racingcar

import camp.nextstep.edu.missionutils.Randoms

class RacingCar(name: String) {
    private var mileage = 0
    fun move() {
        if (Randoms.pickNumberInRange(0, 9) >= 4) {
            mileage++
        }
    }

    fun print() {
        TODO("Not yet implemented")
    }

}
