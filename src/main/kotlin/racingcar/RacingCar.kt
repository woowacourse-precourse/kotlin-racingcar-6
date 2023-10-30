package racingcar

import camp.nextstep.edu.missionutils.Randoms
import racingcar.Constants.FORWARD_THRESHOLD
import racingcar.Constants.POSITION_STEP
import racingcar.Constants.MAXIMUM_DIGIT
import racingcar.Constants.MINIMUM_DIGIT
import racingcar.Constants.PROGRESS_BAR
import racingcar.Constants.START_POSITION

data class RacingCar(
    val name: String,
    var position: Int = START_POSITION
) {

    fun moveForward() {
        if (isAbleToMove()) {
            position += POSITION_STEP
        }
    }

    private fun isAbleToMove(): Boolean {
        val random = Randoms.pickNumberInRange(MINIMUM_DIGIT, MAXIMUM_DIGIT)
        return (FORWARD_THRESHOLD <= random)
    }

    fun printPosition() {
        println("$name : ${PROGRESS_BAR.repeat(position)}")
    }
}