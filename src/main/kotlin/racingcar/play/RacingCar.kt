package racingcar.play

import camp.nextstep.edu.missionutils.Randoms

class RacingCar(var name: String, var distance: Int = 0) {

    private fun createRandomNumber(): Int = Randoms.pickNumberInRange(0, 9)

    fun move() {
        if (createRandomNumber() >= 4) distance++
    }
}