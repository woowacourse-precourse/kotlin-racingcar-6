package racingcar.domain

import camp.nextstep.edu.missionutils.Randoms
import racingcar.utils.Constants.RANGE_START
import racingcar.utils.Constants.RANGE_END
import racingcar.utils.Constants.MIN_MOVEMENT_THRESHOLD

class Car(private val name: String) {
    private var position = 0

    fun moveOrStay() {
        if (isMovable()) {
            position++
        }
    }

    fun showCurrentPositionWithName() {
        val positionString = "-".repeat(position)
        val result = "$name : $positionString"
        println(result)
    }

    fun getPosition() = position

    fun getName() = name

    private fun isMovable(): Boolean = Randoms.pickNumberInRange(RANGE_START, RANGE_END) >= MIN_MOVEMENT_THRESHOLD

    private fun isMovable(): Boolean = Randoms.pickNumberInRange(0, 9) >= 4
}