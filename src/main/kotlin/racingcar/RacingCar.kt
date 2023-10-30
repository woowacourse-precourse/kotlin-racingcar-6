package racingcar

import camp.nextstep.edu.missionutils.Randoms
import racingcar.Constants.FORWARD_THRESHOLD
import racingcar.Constants.LOCATION_STEP
import racingcar.Constants.MAXIMUM_DIGIT
import racingcar.Constants.MINIMUM_DIGIT
import racingcar.Constants.PROGRESS_BAR
import racingcar.Constants.START_LOCATION

data class RacingCar(
    val name: String,
    var location: Int = START_LOCATION
) {

    fun moveForward() {
        if (isAbleToMove()) {
            location += LOCATION_STEP
        }
    }

    private fun isAbleToMove(): Boolean {
        val random = Randoms.pickNumberInRange(MINIMUM_DIGIT, MAXIMUM_DIGIT)
        return (FORWARD_THRESHOLD <= random)
    }

    fun printLocation() {
        println("$name : ${PROGRESS_BAR.repeat(location)}")
    }
}