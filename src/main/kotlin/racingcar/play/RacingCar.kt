package racingcar.play

import camp.nextstep.edu.missionutils.Randoms

const val RANDOM_LOWER_BOUNDARY = 0
const val RANDOM_UPPER_BOUNDARY = 9
const val CAR_MOVE_BOUNDARY = 4

class RacingCar(val name: String, var distance: Int = 0) {

    private fun createRandomNumber(): Int = Randoms.pickNumberInRange(RANDOM_LOWER_BOUNDARY, RANDOM_UPPER_BOUNDARY)

    fun move(random: Int = createRandomNumber()) {
        if (random >= CAR_MOVE_BOUNDARY) distance++
    }
}