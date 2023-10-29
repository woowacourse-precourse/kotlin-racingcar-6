package racingcar.play

import camp.nextstep.edu.missionutils.Randoms

class RacingCar(val name: String, var distance: Int = 0) {

    private fun createRandomNumber(): Int = Randoms.pickNumberInRange(0, 9)

    fun move(random: Int = createRandomNumber()) {
        if (random >= 4) distance++
    }
}